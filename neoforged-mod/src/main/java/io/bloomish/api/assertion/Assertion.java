package io.bloomish.api.assertion;

import java.util.Objects;
import java.util.function.Supplier;

public class Assertion<T, A extends Assertion<T, A>> {
    private final T object;

    protected Assertion(T object) {
        this.object = object;
    }

    public A isTypeOf(Class<?> clazz, Supplier<String> message) {
        return this.assertTrue(clazz.isInstance(this.object), message);
    }

    public A isNotTypeOf(Class<?> clazz, Supplier<String> message) {
        return this.assertFalse(clazz.isInstance(this.object), message);
    }

    public A isEqual(T other, Supplier<String> message) {
        return this.assertTrue(Objects.equals(this.object, other), message);
    }

    public A isNotEqual(T other, Supplier<String> message) {
        return this.assertFalse(Objects.equals(this.object, other), message);
    }

    public A isSame(T other, Supplier<String> message) {
        return this.assertTrue(this.object == other, message);
    }

    public A isNotSame(T other, Supplier<String> message) {
        return this.assertFalse(this.object == other, message);
    }

    public A isNull(Supplier<String> message) {
        return this.assertTrue(object == null, message);
    }

    public A isNotNull(Supplier<String> message) {
        return this.assertFalse(object == null, message);
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

    protected T getObject() {
        return object;
    }
}
