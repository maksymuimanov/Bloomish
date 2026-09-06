package io.bloomish.api.validation;

import java.util.function.Supplier;

public class ClassValidation extends Validation<Class<?>, ClassValidation> {
    protected ClassValidation(Class<?> actual) {
        super(actual);
    }

    public ClassValidation isSubtypeOf(Class<?> expected) {
        return this.isSubtypeOf(expected, () -> "Expected object to be a subtype of " + expected.getName());
    }

    public ClassValidation isSubtypeOf(Class<?> expected, String message) {
        return this.isSubtypeOf(expected, () -> message);
    }

    public ClassValidation isSubtypeOf(Class<?> expected, Supplier<String> message) {
        return this.assertTrue(expected.isAssignableFrom(this.getActual()), message);
    }

    public ClassValidation isNotSubtypeOf(Class<?> expected) {
        return this.isSubtypeOf(expected, () -> "Expected object not to be a subtype of " + expected.getName());
    }

    public ClassValidation isNotSubtypeOf(Class<?> expected, String message) {
        return this.isSubtypeOf(expected, () -> message);
    }

    public ClassValidation isNotSubtypeOf(Class<?> expected, Supplier<String> message) {
        return this.assertFalse(expected.isAssignableFrom(this.getActual()), message);
    }
}
