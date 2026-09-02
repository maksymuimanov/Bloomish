package io.bloomish.api.assertion;

import java.util.Objects;
import java.util.function.Supplier;

public class Assertion<T, A extends Assertion<T, A>> {
    private final T actual;

    protected Assertion(T actual) {
        this.actual = actual;
    }

    public A isTypeOf(Class<?> clazz) {
        return this.isTypeOf(clazz, () -> "Expected object to be of type " + clazz.getName());
    }

    public A isTypeOf(Class<?> clazz, Supplier<String> message) {
        return this.assertTrue(clazz.isInstance(this.actual), message);
    }

    public A isNotTypeOf(Class<?> clazz) {
        return this.isNotTypeOf(clazz, () -> "Expected object not to be of type " + clazz.getName());
    }

    public A isNotTypeOf(Class<?> clazz, Supplier<String> message) {
        return this.assertFalse(clazz.isInstance(this.actual), message);
    }

    public A isEqual(T expected) {
        return this.isEqual(expected, () -> "Expected " + this.actual + " to equal " + expected);
    }

    public A isEqual(T expected, Supplier<String> message) {
        return this.assertTrue(Objects.equals(this.actual, expected), message);
    }

    public A isNotEqual(T expected) {
        return this.isNotEqual(expected, () -> "Expected " + this.actual + " not to equal " + expected);
    }

    public A isNotEqual(T expected, Supplier<String> message) {
        return this.assertFalse(Objects.equals(this.actual, expected), message);
    }

    public A isSame(T expected) {
        return this.isSame(expected, () -> "Expected object to be same as " + expected);
    }

    public A isSame(T expected, Supplier<String> message) {
        return this.assertTrue(this.actual == expected, message);
    }

    public A isNotSame(T expected) {
        return this.isNotSame(expected, () -> "Expected object not to be same as " + expected);
    }

    public A isNotSame(T expected, Supplier<String> message) {
        return this.assertFalse(this.actual == expected, message);
    }

    public A isNull() {
        return this.isNull(() -> "Expected object to be null");
    }

    public A isNull(Supplier<String> message) {
        return this.assertTrue(actual == null, message);
    }

    public A isNotNull() {
        return this.isNotNull(() -> "Expected object not to be null");
    }

    public A isNotNull(Supplier<String> message) {
        return this.assertFalse(actual == null, message);
    }

    public A assertTrue(boolean condition, Supplier<String> message) {
        return this.failIf(!condition, message);
    }

    public A assertFalse(boolean condition, Supplier<String> message) {
        return this.failIf(condition, message);
    }

    protected A failIf(boolean condition, Supplier<String> message) {
        if (condition) {
            throw new AssertionError(message.get());
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
