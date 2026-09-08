package io.bloomish.api.context;

import io.bloomish.api.util.CollectionUtils;
import io.bloomish.api.validation.Validations;
import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class DefaultObjectRegistry implements ObjectRegistry {
    private final Map<ObjectKey<?>, Object> objects;

    protected DefaultObjectRegistry() {
        this.objects = new ConcurrentHashMap<>();
    }

    @Override
    public boolean isRegistered(String name) {
        Validations.validateThatString(name).isNotBlank();
        return this.objects.keySet()
                .stream()
                .anyMatch(key -> key.name().equals(name));
    }

    @Override
    public boolean isRegistered(Class<?> clazz) {
        Validations.validateThat(clazz).isNotNull();
        return this.objects.keySet()
                .stream()
                .anyMatch(key -> key.clazz().equals(clazz));
    }

    @Override
    public boolean isRegistered(ObjectKey<?> key) {
        Validations.validateThat(key).isNotNull();
        return this.objects.containsKey(key);
    }

    @Override
    public <T> Collection<T> findAllByClass(Class<T> clazz) {
        Validations.validateThat(clazz).isNotNull();
        return this.objects.values()
                .stream()
                .filter(clazz::isInstance)
                .map(clazz::cast)
                .toList();
    }

    @Override
    public Optional<Object> findByName(String name) {
        Validations.validateThatString(name).isNotBlank();
        List<Map.Entry<ObjectKey<?>, Object>> values = this.objects.entrySet()
                .stream()
                .filter(entry -> entry.getKey().name().equals(name))
                .toList();
        if (values.isEmpty()) {
            return Optional.empty();
        } else {
            Validations.validateThatCollection(values)
                    .hasSize(1, "Multiple values found for name: " + name);
            return Optional.of(values.getFirst().getValue());
        }
    }

    @Override
    public <T> Optional<T> findByClass(Class<? extends T> clazz) {
        Validations.validateThat(clazz).isNotNull();
        List<Map.Entry<ObjectKey<?>, Object>> values = this.objects.entrySet()
                .stream()
                .filter(entry -> entry.getKey().clazz().equals(clazz))
                .toList();
        if (values.isEmpty()) {
            return Optional.empty();
        } else if (values.size() == 1) {
            return Optional.of(clazz.cast(values.getFirst().getValue()));
        } else {
            List<Object> primaryValues = values.stream()
                    .filter(entry -> entry.getKey().primary())
                    .map(Map.Entry::getValue)
                    .toList();
            Validations.validateThatCollection(primaryValues)
                    .hasSize(1, "Exactly one primary value is required for class: " + clazz.getName());
            return Optional.of(clazz.cast(primaryValues.getFirst()));
        }
    }

    @Override
    public <T> Optional<T> findByKey(ObjectKey<T> key) {
        Validations.validateThat(key).isNotNull();
        Object value = this.objects.get(key);
        return Optional.ofNullable(key.clazz().cast(value));
    }

    @Override
    public Collection<ObjectKey<?>> keys() {
        return Set.copyOf(this.objects.keySet());
    }

    @Override
    public Collection<?> values() {
        return Set.copyOf(this.objects.values());
    }

    @Override
    public void registerAll(Object value, Object... values) {
        Validations.validateThat(value).isNotNull();
        List<Object> valueList = CollectionUtils.arrayListOf(value, values);
        valueList.forEach(this::register);
    }

    @Override
    public void register(Object value) {
        Validations.validateThat(value).isNotNull();
        Class<?> clazz = value.getClass();
        ObjectKey<?> objectKey = new ObjectKey<>(clazz.getSimpleName(), clazz, false);
        this.putValue(value, objectKey);
    }

    @Override
    public void registerByName(Object value, String name) {
        Validations.validateThat(value).isNotNull();
        Validations.validateThatString(name).isNotBlank();
        ObjectKey<?> objectKey = new ObjectKey<>(name, value.getClass(), false);
        this.putValue(value, objectKey);
    }

    @Override
    public <T> void registerByKey(T value, ObjectKey<T> key) {
        Validations.validateThat(value).isNotNull();
        Validations.validateThat(key).isNotNull();
        this.putValue(value, key);
    }

    private void putValue(Object value, ObjectKey<?> objectKey) {
        Object result = this.objects.putIfAbsent(objectKey, value);
        Validations.validateThat(result).isNull(() -> "Value already registered: " + objectKey);
    }

    @Override
    public void unregisterAllByClass(Class<?> clazz) {
        Validations.validateThat(clazz).isNotNull();
        boolean removed = this.objects.keySet().removeIf(key -> clazz.isAssignableFrom(key.clazz()));
        Validations.validateThatBoolean(removed).isTrue(() -> "No values registered by class: " + clazz.getName());
    }

    @Override
    public void unregister(Object value) {
        Validations.validateThat(value).isNotNull();
        boolean isRemoved = this.objects.values().remove(value);
        Validations.validateThatBoolean(isRemoved).isTrue(() -> "Value not registered: " + value.getClass().getName());
    }

    @Override
    public void unregisterByName(String name) {
        Validations.validateThatString(name).isNotBlank();
        boolean isRemoved = this.objects.keySet().removeIf(key -> key.name().equals(name));
        Validations.validateThatBoolean(isRemoved).isTrue(() -> "Value not registered by name: " + name);
    }

    @Override
    public void unregisterByKey(ObjectKey<?> key) {
        Validations.validateThat(key).isNotNull();
        Object removed = this.objects.remove(key);
        Validations.validateThat(removed).isNotNull(() -> "Value not registered by key: " + key);
    }

    @Override
    public void clear() {
        this.objects.clear();
    }

    @SuppressWarnings("unchecked")
    @NotNull
    @Override
    public Iterator<Object> iterator() {
        return (Iterator<Object>) this.values().iterator();
    }
}