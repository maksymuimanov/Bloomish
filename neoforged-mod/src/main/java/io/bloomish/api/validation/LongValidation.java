package io.bloomish.api.validation;

import java.util.function.Supplier;

public class LongValidation extends Validation<Long, LongValidation> {
    protected LongValidation(Long object) {
        super(object);
    }

    public LongValidation isPositive() {
        return this.isPositive(() -> "Expected value to be positive");
    }

    public LongValidation isPositive(String message) {
        return this.isPositive(() -> message);
    }

    public LongValidation isPositive(Supplier<String> message) {
        return this.isTrue(this.getActual() > 0, message);
    }

    public LongValidation isNegative() {
        return this.isNegative(() -> "Expected value to be negative");
    }

    public LongValidation isNegative(String message) {
        return this.isNegative(() -> message);
    }

    public LongValidation isNegative(Supplier<String> message) {
        return this.isTrue(this.getActual() < 0, message);
    }

    public LongValidation isZero() {
        return this.isZero(() -> "Expected value to be zero");
    }

    public LongValidation isZero(String message) {
        return this.isZero(() -> message);
    }

    public LongValidation isZero(Supplier<String> message) {
        return this.isTrue(this.getActual() == 0, message);
    }

    public LongValidation isNotZero() {
        return this.isNotZero(() -> "Expected value not to be zero");
    }

    public LongValidation isNotZero(String message) {
        return this.isNotZero(() -> message);
    }

    public LongValidation isNotZero(Supplier<String> message) {
        return this.isFalse(this.getActual() == 0, message);
    }

    public LongValidation isBetween(Long min, Long max) {
        return this.isBetween(min, max, () -> "Expected value to be between " + min + " and " + max);
    }

    public LongValidation isBetween(Long min, Long max, String message) {
        return this.isBetween(min, max, () -> message);
    }

    public LongValidation isBetween(Long min, Long max, Supplier<String> message) {
        return this.isTrue(this.getActual() >= min && this.getActual() <= max, message);
    }

    public LongValidation isNotBetween(Long min, Long max) {
        return this.isNotBetween(min, max, () -> "Expected value not to be between " + min + " and " + max);
    }

    public LongValidation isNotBetween(Long min, Long max, String message) {
        return this.isNotBetween(min, max, () -> message);
    }

    public LongValidation isNotBetween(Long min, Long max, Supplier<String> message) {
        return this.isFalse(this.getActual() >= min && this.getActual() <= max, message);
    }

    public LongValidation isGreaterThan(Long expected) {
        return this.isGreaterThan(expected, () -> "Expected value to be greater than " + expected);
    }

    public LongValidation isGreaterThan(Long expected, String message) {
        return this.isGreaterThan(expected, () -> message);
    }

    public LongValidation isGreaterThan(Long expected, Supplier<String> message) {
        return this.isTrue(this.getActual() > expected, message);
    }

    public LongValidation isGreaterThanOrEqualTo(Long expected) {
        return this.isGreaterThanOrEqualTo(expected, () -> "Expected value to be greater than or equal to " + expected);
    }

    public LongValidation isGreaterThanOrEqualTo(Long expected, String message) {
        return this.isGreaterThanOrEqualTo(expected, () -> message);
    }

    public LongValidation isGreaterThanOrEqualTo(Long expected, Supplier<String> message) {
        return this.isTrue(this.getActual() >= expected, message);
    }

    public LongValidation isLessThan(Long expected) {
        return this.isLessThan(expected, () -> "Expected value to be less than " + expected);
    }

    public LongValidation isLessThan(Long expected, String message) {
        return this.isLessThan(expected, () -> message);
    }

    public LongValidation isLessThan(Long expected, Supplier<String> message) {
        return this.isTrue(this.getActual() < expected, message);
    }

    public LongValidation isLessThanOrEqualTo(Long expected) {
        return this.isLessThanOrEqualTo(expected, () -> "Expected value to be less than or equal to " + expected);
    }

    public LongValidation isLessThanOrEqualTo(Long expected, String message) {
        return this.isLessThanOrEqualTo(expected, () -> message);
    }

    public LongValidation isLessThanOrEqualTo(Long expected, Supplier<String> message) {
        return this.isTrue(this.getActual() <= expected, message);
    }
}
