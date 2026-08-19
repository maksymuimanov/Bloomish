package io.bloomish.api.engine.context;

import io.bloomish.api.util.ReflectionUtils;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Predicate;

public class DefaultObjectRegistry implements ObjectRegistry {
    private final Map<ObjectKey<?>, Object> objects;

    protected DefaultObjectRegistry() {
        this.objects = new ConcurrentHashMap<>();
    }

    @Override
    public void registerAllValues(Object... values) {
        if (values == null) throw new ObjectRegistryException("Values cannot be null");
        for (Object value : values) {
            this.registerValue(value);
        }
    }

    @Override
    public void registerValue(Object value) {
        ObjectKey<?> key = new ObjectKey<>(value);
        this.registerValueByKey(value, key);
    }

    @Override
    public void registerValueByName(Object value, String name) {
        ObjectKey<?> key = new ObjectKey<>(name, value);
        this.registerValueByKey(value, key);
    }

    @Override
    public void registerValueByClass(Class<?> clazz) {
        ObjectKey<?> key = new ObjectKey<>(clazz);
        Object object = ReflectionUtils.createObject(clazz);
        this.registerValueByKey(object, key);
    }

    @Override
    public <T> void registerValueByClass(T value, Class<? extends T> clazz) {
        ObjectKey<? extends T> key = new ObjectKey<>(clazz);
        this.registerValueByKey(value, key);
    }

    @Override
    public void registerValueByKey(ObjectKey<?> key) {
        Object object = ReflectionUtils.createObject(key.clazz());
        this.registerValueByKey(object, key);
    }

    @Override
    public <T> void registerValueByKey(T value, ObjectKey<? extends T> key) {
        this.objects.put(key, value);
    }

    @Override
    public void unregisterByName(String name) {
        ObjectKey<?> key = this.getKeyByName(name);
        this.objects.remove(key);
    }

    @Override
    public void unregisterByClass(Class<?> clazz) {
        ObjectKey<?> key = this.getKeyByClass(clazz);
        this.objects.remove(key);
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
                .anyMatch(key -> clazz.isAssignableFrom(key.clazz()));
    }

    @Override
    public Collection<?> getAll() {
        return List.copyOf(this.objects.values());
    }

    @Override
    public <T> Collection<T> getAll(Class<T> commonInterface) {
        return this.objects.values()
                .stream()
                .filter(commonInterface::isInstance)
                .map(commonInterface::cast)
                .toList();
    }

    @Override
    public Object getByName(String name) {
        ObjectKey<?> key = this.getKeyByName(name);
        return this.get(key);
    }

    @Override
    public Object getByNameOrNull(String name) {
        ObjectKey<?> key = this.getKeyByNameOrNull(name);
        return this.getOrNull(key);
    }

    @Override
    public <T> T getByName(String name, Class<T> clazz) {
        ObjectKey<?> key = this.getKeyByName(name);
        return clazz.cast(this.get(key));
    }

    @Override
    public <T> T getByNameOrNull(String name, Class<T> clazz) {
        ObjectKey<?> key = this.getKeyByNameOrNull(name);
        return clazz.cast(this.getOrNull(key));
    }

    @Override
    public <T> T getByClass(Class<? extends T> clazz) {
        ObjectKey<? extends T> key = this.getKeyByClass(clazz);
        return this.get(key);
    }

    @Override
    public <T> T getByClassOrNull(Class<? extends T> clazz) {
        ObjectKey<? extends T> key = this.getKeyByClassOrNull(clazz);
        return this.getOrNull(key);
    }

    @Override
    public <T> T get(ObjectKey<T> key) {
        Object object = objects.get(key);
        if (object == null) throw new ObjectRegistryException("No object registered for key: " + key);
        return key.clazz().cast(object);
    }

    @Override
    public <T> T getOrNull(ObjectKey<T> key) {
        Object object = objects.get(key);
        return key.clazz().cast(object);
    }

    @Override
    public ObjectKey<?> getKeyByName(String name) {
        return this.getKey(key -> key.name().equals(name));
    }

    @Override
    public ObjectKey<?> getKeyByNameOrNull(String name) {
        return this.getKeyOrNull(key -> key.name().equals(name));
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> ObjectKey<T> getKeyByClass(Class<? extends T> clazz) {
        return (ObjectKey<T>) this.getKey(key -> clazz.isAssignableFrom(key.clazz()));
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> ObjectKey<T> getKeyByClassOrNull(Class<? extends T> clazz) {
        return (ObjectKey<T>) this.getKeyOrNull(key -> clazz.isAssignableFrom(key.clazz()));
    }

    @Override
    public ObjectKey<?> getKey(Predicate<? super ObjectKey<?>> predicate) {
        List<ObjectKey<?>> keys = this.objects.keySet()
                .stream()
                .filter(predicate)
                .toList();
        if (keys.size() > 1) {
            throw new ObjectRegistryException("Multiple objects registered for predicate");
        }
        if (keys.isEmpty()) {
            throw new ObjectRegistryException("No object registered for predicate");
        }
        return keys.getFirst();
    }

    @Override
    public ObjectKey<?> getKeyOrNull(Predicate<? super ObjectKey<?>> predicate) {
        List<ObjectKey<?>> keys = this.objects.keySet()
                .stream()
                .filter(predicate)
                .toList();
        if (keys.size() > 1) {
            throw new ObjectRegistryException("Multiple objects registered for predicate");
        }
        return keys.isEmpty() ? null : keys.getFirst();
    }

    @Override
    public void clear() {
        this.objects.clear();
    }

    @Override
    @NotNull
    public Iterator<Object> iterator() {
        return this.objects.values().iterator();
    }
}
