package io.bloomish.api.engine.context;

public record ObjectKey<T>(
        String name,
        Class<T> clazz
) {
    @SuppressWarnings("unchecked")
    public ObjectKey(T object) {
        this((Class<T>) object.getClass());
    }

    public ObjectKey(Class<T> clazz) {
        this(clazz.getSimpleName(), clazz);
    }

    @SuppressWarnings("unchecked")
    public ObjectKey(String name, T object) {
        this(name, (Class<T>) object.getClass());
    }
}
