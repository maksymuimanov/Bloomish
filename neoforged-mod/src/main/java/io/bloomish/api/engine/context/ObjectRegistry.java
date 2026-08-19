package io.bloomish.api.engine.context;

import java.util.Collection;
import java.util.function.Predicate;

public interface ObjectRegistry extends Iterable<Object> {
    void register(String name, Class<?> clazz);

    void register(Class<?> clazz);

    void register(Object value);

    void register(String name, Object value);

    <T> void register(Class<? extends T> clazz, T value);

    <T> void register(ObjectKey<? extends T> key, T value);

    void unregister(String name);

    void unregister(Class<?> clazz);

    boolean isRegistered(String name);

    boolean isRegistered(Class<?> clazz);

    boolean isRegistered(ObjectKey<?> key);

    Collection<?> getAll();

    <T> Collection<T> getAll(Class<T> commonInterface);

    Object get(String name);

    Object getOrNull(String name);

    <T> T get(String name, Class<T> clazz);

    <T> T getOrNull(String name, Class<T> clazz);

    <T> T get(Class<? extends T> clazz);

    <T> T getOrNull(Class<? extends T> clazz);

    <T> T get(ObjectKey<T> key);

    <T> T getOrNull(ObjectKey<T> key);

    ObjectKey<?> getKey(String name);

    ObjectKey<?> getKeyOrNull(String name);

    <T> ObjectKey<T> getKey(Class<? extends T> clazz);

    <T> ObjectKey<T> getKeyOrNull(Class<? extends T> clazz);

    ObjectKey<?> getKey(Predicate<? super ObjectKey<?>> predicate);

    ObjectKey<?> getKeyOrNull(Predicate<? super ObjectKey<?>> predicate);

    void clear();
}
