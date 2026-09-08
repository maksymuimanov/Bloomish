package io.bloomish.api.validation;

import java.util.function.Supplier;

public class BooleanValidation extends Validation<Boolean, BooleanValidation> {
    protected BooleanValidation(Boolean object) {
        super(object);
    }

    public BooleanValidation isTrue() {
        return this.isTrue(() -> "Expected boolean to be true");
    }

    public BooleanValidation isTrue(String message) {
        return this.isTrue(() -> message);
    }

    public BooleanValidation isTrue(Supplier<String> message) {
        return this.isCondition(Boolean.TRUE::equals, message);
    }

    public BooleanValidation isFalse() {
        return this.isFalse(() -> "Expected boolean to be false");
    }

    public BooleanValidation isFalse(String message) {
        return this.isFalse(() -> message);
    }

    public BooleanValidation isFalse(Supplier<String> message) {
        return this.isCondition(Boolean.FALSE::equals, message);
    }
}
