package io.bloomish.api.engine.context;

import java.util.Collection;
import java.util.function.Predicate;

public interface ObjectRegistry extends Iterable<Object> {
    void registerAllValues(Object... values);

    void registerValue(Object value);

    void registerValueByName(Object value, String name);

    void registerValueByClass(Class<?> clazz);

    <T> void registerValueByClass(T value, Class<? extends T> clazz);

    void registerValueByKey(ObjectKey<?> key);

    <T> void registerValueByKey(T value, ObjectKey<? extends T> key);

    void unregisterByName(String name);

    void unregisterByClass(Class<?> clazz);

    boolean isRegistered(String name);

    boolean isRegistered(Class<?> clazz);

    Collection<?> getAll();

    <T> Collection<T> getAll(Class<T> commonInterface);

    Object getByName(String name);

    Object getByNameOrNull(String name);

    <T> T getByName(String name, Class<T> clazz);

    <T> T getByNameOrNull(String name, Class<T> clazz);

    <T> T getByClass(Class<? extends T> clazz);

    <T> T getByClassOrNull(Class<? extends T> clazz);

    <T> T get(ObjectKey<T> key);

    <T> T getOrNull(ObjectKey<T> key);

    ObjectKey<?> getKeyByName(String name);

    ObjectKey<?> getKeyByNameOrNull(String name);

    <T> ObjectKey<T> getKeyByClass(Class<? extends T> clazz);

    <T> ObjectKey<T> getKeyByClassOrNull(Class<? extends T> clazz);

    ObjectKey<?> getKey(Predicate<? super ObjectKey<?>> predicate);

    ObjectKey<?> getKeyOrNull(Predicate<? super ObjectKey<?>> predicate);

    void clear();
}
