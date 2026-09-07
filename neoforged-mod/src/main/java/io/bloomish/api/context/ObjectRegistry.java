package io.bloomish.api.context;

import java.util.Collection;
import java.util.Optional;

public interface ObjectRegistry extends Iterable<Object> {
    boolean isRegistered(String name);

    boolean isRegistered(Class<?> clazz);

    boolean isRegistered(ObjectKey<?> key);

    <T> Collection<T> findAllByInterface(Class<T> commonInterface);

    Optional<Object> findByName(String name);

    <T> Optional<T> findByClass(Class<? extends T> clazz);

    <T> Optional<T> findByKey(ObjectKey<T> key);

    Collection<ObjectKey<?>> keys();

    Collection<?> values();

    void registerAll(Object value, Object... values);

    void register(Object value);

    void registerByName(Object value, String name);

    <T> void registerByKey(T value, ObjectKey<T> key);

    void unregister(Object value);

    void unregisterByName(String name);

    void unregisterByClass(Class<?> clazz);

    void unregisterByKey(ObjectKey<?> key);

    void clear();
}
