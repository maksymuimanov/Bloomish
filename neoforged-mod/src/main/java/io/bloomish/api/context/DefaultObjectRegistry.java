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
        return this.objects.keySet()
                .stream()
                .anyMatch(key -> key.name().equals(name));
    }

    @Override
    public boolean isRegistered(Class<?> clazz) {
        return this.objects.keySet()
                .stream()
                .anyMatch(key -> key.clazz().equals(clazz));
    }

    @Override
    public boolean isRegistered(ObjectKey<?> key) {
        return this.objects.containsKey(key);
    }

    @Override
    public <T> Collection<T> findAllByInterface(Class<T> commonInterface) {
        return this.objects.values()
                .stream()
                .filter(commonInterface::isInstance)
                .map(commonInterface::cast)
                .toList();
    }

    @Override
    public Optional<Object> findByName(String name) {
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

    @SuppressWarnings("unchecked")
    @Override
    public <T> Optional<T> findByClass(Class<? extends T> clazz) {
        List<Map.Entry<ObjectKey<?>, Object>> values = this.objects.entrySet()
                .stream()
                .filter(entry -> entry.getKey().clazz().equals(clazz))
                .toList();
        if (values.isEmpty()) {
            return Optional.empty();
        } else if (values.size() == 1) {
            return (Optional<T>) Optional.of(values.getFirst().getValue());
        } else {
            List<Object> primaryValues = values.stream()
                    .filter(entry -> entry.getKey().primary())
                    .map(Map.Entry::getValue)
                    .toList();
            Validations.validateThatCollection(primaryValues)
                    .hasSize(1, "Primary values cannot have more than one value");
            return (Optional<T>) Optional.of(primaryValues.getFirst());
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> Optional<T> findByKey(ObjectKey<T> key) {
        List<Map.Entry<ObjectKey<?>, Object>> values = this.objects.entrySet()
                .stream()
                .filter(entry -> entry.getKey().equals(key))
                .toList();
        if (values.isEmpty()) {
            return Optional.empty();
        } else {
            Validations.validateThatCollection(values)
                    .hasSize(1, "Multiple values found for key: " + key);
            return (Optional<T>) Optional.of(values.getFirst().getValue());
        }
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
        Validations.validateThat(value).isNotNull("Value cannot be null");
        List<Object> valueList = CollectionUtils.arrayListOf(value, values);
        valueList.forEach(this::register);
    }

    @Override
    public void register(Object value) {
        Validations.validateThat(value).isNotNull("Value cannot be null");
        Class<?> clazz = value.getClass();
        ObjectKey<?> objectKey = new ObjectKey<>(clazz.getSimpleName(), clazz, false);
        this.objects.put(objectKey, value);
    }

    @Override
    public void registerByName(Object value, String name) {
        Validations.validateThat(value).isNotNull("Value cannot be null");
        Validations.validateThatString(name).isNotBlank("Name cannot be blank");
        ObjectKey<?> objectKey = new ObjectKey<>(name, value.getClass(), false);
        this.objects.put(objectKey, value);
    }

    @Override
    public <T> void registerByKey(T value, ObjectKey<T> key) {
        Validations.validateThat(value).isNotNull("Value cannot be null");
        Validations.validateThat(key).isNotNull("Key cannot be null");
        this.objects.put(key, value);
    }

    @Override
    public void unregister(Object value) {
        Validations.validateThat(value)
                .isNotNull("Value cannot be null");
        ObjectKey<?> objectKey = this.objects.entrySet()
                .stream()
                .filter(entry -> entry.getValue().equals(value))
                .map(Map.Entry::getKey)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Value not registered"));
        this.objects.remove(objectKey);
    }

    @Override
    public void unregisterByName(String name) {
        Validations.validateThatString(name)
                .isNotBlank("Name cannot be blank");
        ObjectKey<?> objectKey = this.objects.keySet()
                .stream()
                .filter(key -> key.name().equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Value not registered by name"));
        this.objects.remove(objectKey);
    }

    @Override
    public void unregisterByClass(Class<?> clazz) {
        Validations.validateThat(clazz)
                .isNotNull("Class cannot be null");
        ObjectKey<?> objectKey = this.objects.keySet()
                .stream()
                .filter(key -> key.clazz().equals(clazz))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Value not registered by class"));
        this.objects.remove(objectKey);
    }

    @Override
    public void unregisterByKey(ObjectKey<?> key) {
        Validations.validateThat(key)
                .isNotNull("Key cannot be null")
                .isTrue(this.objects.containsKey(key), "Value not registered by key");
        this.objects.remove(key);
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