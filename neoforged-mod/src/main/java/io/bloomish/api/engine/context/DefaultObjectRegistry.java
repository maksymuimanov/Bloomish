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
    public void register(String name, Class<?> clazz) {
        ObjectKey<?> key = new ObjectKey<>(name, clazz);
        Object object = ReflectionUtils.createObject(clazz);
        this.register(key, object);
    }

    @Override
    public void register(Class<?> clazz) {
        ObjectKey<?> key = new ObjectKey<>(clazz);
        Object object = ReflectionUtils.createObject(clazz);
        this.register(key, object);
    }

    @Override
    public void register(Object value) {
        ObjectKey<?> key = new ObjectKey<>(value);
        this.register(key, value);
    }

    @Override
    public void register(String name, Object value) {
        ObjectKey<?> key = new ObjectKey<>(name, value);
        this.register(key, value);
    }

    @Override
    public <T> void register(Class<? extends T> clazz, T value) {
        ObjectKey<? extends T> key = new ObjectKey<>(clazz);
        this.register(key, value);
    }

    @Override
    public <T> void register(ObjectKey<? extends T> key, T value) {
        this.objects.put(key, value);
    }

    @Override
    public void unregister(String name) {
        ObjectKey<?> key = this.getKey(name);
        this.objects.remove(key);
    }

    @Override
    public void unregister(Class<?> clazz) {
        ObjectKey<?> key = this.getKey(clazz);
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
    public boolean isRegistered(ObjectKey<?> key) {
        return this.objects.containsKey(key);
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
    public Object get(String name) {
        ObjectKey<?> key = this.getKey(name);
        return this.get(key);
    }

    @Override
    public Object getOrNull(String name) {
        ObjectKey<?> key = this.getKeyOrNull(name);
        return this.getOrNull(key);
    }

    @Override
    public <T> T get(String name, Class<T> clazz) {
        ObjectKey<?> key = this.getKey(name);
        return clazz.cast(this.get(key));
    }

    @Override
    public <T> T getOrNull(String name, Class<T> clazz) {
        ObjectKey<?> key = this.getKeyOrNull(name);
        return clazz.cast(this.getOrNull(key));
    }

    @Override
    public <T> T get(Class<? extends T> clazz) {
        ObjectKey<? extends T> key = this.getKey(clazz);
        return this.get(key);
    }

    @Override
    public <T> T getOrNull(Class<? extends T> clazz) {
        ObjectKey<? extends T> key = this.getKeyOrNull(clazz);
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
    public ObjectKey<?> getKey(String name) {
        return this.getKey(key -> key.name().equals(name));
    }

    @Override
    public ObjectKey<?> getKeyOrNull(String name) {
        return this.getKeyOrNull(key -> key.name().equals(name));
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> ObjectKey<T> getKey(Class<? extends T> clazz) {
        return (ObjectKey<T>) this.getKey(key -> clazz.isAssignableFrom(key.clazz()));
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> ObjectKey<T> getKeyOrNull(Class<? extends T> clazz) {
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
