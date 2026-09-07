package io.bloomish.api.validation;

import java.util.Objects;
import java.util.function.Supplier;

public class Validation<T, A extends Validation<T, A>> {
    private final T actual;

    protected Validation(T actual) {
        this.actual = actual;
    }

    public A isTypeOf(Class<?> clazz) {
        return this.isTypeOf(clazz, () -> "Expected object to be of type " + clazz.getName());
    }

    public A isTypeOf(Class<?> clazz, String message) {
        return this.isTypeOf(clazz, () -> message);
    }

    public A isTypeOf(Class<?> clazz, Supplier<String> message) {
        return this.isTrue(clazz.isInstance(this.actual), message);
    }

    public A isNotTypeOf(Class<?> clazz) {
        return this.isNotTypeOf(clazz, () -> "Expected object not to be of type " + clazz.getName());
    }

    public A isNotTypeOf(Class<?> clazz, String message) {
        return this.isNotTypeOf(clazz, () -> message);
    }

    public A isNotTypeOf(Class<?> clazz, Supplier<String> message) {
        return this.isFalse(clazz.isInstance(this.actual), message);
    }

    public A isEqual(T expected) {
        return this.isEqual(expected, () -> "Expected " + this.actual + " to equal " + expected);
    }

    public A isEqual(T expected, String message) {
        return this.isEqual(expected, () -> message);
    }

    public A isEqual(T expected, Supplier<String> message) {
        return this.isTrue(Objects.equals(this.actual, expected), message);
    }

    public A isNotEqual(T expected) {
        return this.isNotEqual(expected, () -> "Expected " + this.actual + " not to equal " + expected);
    }

    public A isNotEqual(T expected, String message) {
        return this.isNotEqual(expected, () -> message);
    }

    public A isNotEqual(T expected, Supplier<String> message) {
        return this.isFalse(Objects.equals(this.actual, expected), message);
    }

    public A isSame(T expected) {
        return this.isSame(expected, () -> "Expected object to be same as " + expected);
    }

    public A isSame(T expected, String message) {
        return this.isSame(expected, () -> message);
    }

    public A isSame(T expected, Supplier<String> message) {
        return this.isTrue(this.actual == expected, message);
    }

    public A isNotSame(T expected) {
        return this.isNotSame(expected, () -> "Expected object not to be same as " + expected);
    }

    public A isNotSame(T expected, String message) {
        return this.isNotSame(expected, () -> message);
    }

    public A isNotSame(T expected, Supplier<String> message) {
        return this.isFalse(this.actual == expected, message);
    }

    public A isNull() {
        return this.isNull(() -> "Expected object to be null");
    }

    public A isNull(String message) {
        return this.isNull(() -> message);
    }

    public A isNull(Supplier<String> message) {
        return this.isTrue(actual == null, message);
    }

    public A isNotNull() {
        return this.isNotNull(() -> "Expected object not to be null");
    }

    public A isNotNull(String message) {
        return this.isNotNull(() -> message);
    }

    public A isNotNull(Supplier<String> message) {
        return this.isFalse(actual == null, message);
    }

    public A isTrue(boolean condition, String message) {
        return this.isTrue(condition, () -> message);
    }

    public A isTrue(boolean condition, Supplier<String> message) {
        return this.failIf(!condition, message);
    }

    public A isFalse(boolean condition, String message) {
        return this.isFalse(condition, () -> message);
    }

    public A isFalse(boolean condition, Supplier<String> message) {
        return this.failIf(condition, message);
    }

    protected A failIf(boolean condition, Supplier<String> message) {
        if (condition) {
            throw new IllegalArgumentException(message.get());
        }
        return this.self();
    }

    @SuppressWarnings("unchecked")
    protected A self() {
        return (A) this;
    }

    protected T getActual() {
        return actual;
    }
}
