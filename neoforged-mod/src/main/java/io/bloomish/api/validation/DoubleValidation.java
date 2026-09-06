package io.bloomish.api.validation;

import java.util.function.Supplier;

public class DoubleValidation extends Validation<Double, DoubleValidation> {
    protected DoubleValidation(Double object) {
        super(object);
    }

    public DoubleValidation isPositive() {
        return this.isPositive(() -> "Expected value to be positive");
    }

    public DoubleValidation isPositive(String message) {
        return this.isPositive(() -> message);
    }

    public DoubleValidation isPositive(Supplier<String> message) {
        return this.assertTrue(this.getActual() > 0, message);
    }

    public DoubleValidation isNegative() {
        return this.isNegative(() -> "Expected value to be negative");
    }

    public DoubleValidation isNegative(String message) {
        return this.isNegative(() -> message);
    }

    public DoubleValidation isNegative(Supplier<String> message) {
        return this.assertTrue(this.getActual() < 0, message);
    }

    public DoubleValidation isZero() {
        return this.isZero(() -> "Expected value to be zero");
    }

    public DoubleValidation isZero(String message) {
        return this.isZero(() -> message);
    }

    public DoubleValidation isZero(Supplier<String> message) {
        return this.assertTrue(this.getActual() == 0, message);
    }

    public DoubleValidation isNotZero() {
        return this.isNotZero(() -> "Expected value not to be zero");
    }

    public DoubleValidation isNotZero(String message) {
        return this.isNotZero(() -> message);
    }

    public DoubleValidation isNotZero(Supplier<String> message) {
        return this.assertFalse(this.getActual() == 0, message);
    }

    public DoubleValidation isBetween(Double min, Double max) {
        return this.isBetween(min, max, () -> "Expected value to be between " + min + " and " + max);
    }

    public DoubleValidation isBetween(Double min, Double max, String message) {
        return this.isBetween(min, max, () -> message);
    }

    public DoubleValidation isBetween(Double min, Double max, Supplier<String> message) {
        return this.assertTrue(this.getActual() >= min && this.getActual() <= max, message);
    }

    public DoubleValidation isNotBetween(Double min, Double max) {
        return this.isNotBetween(min, max, () -> "Expected value not to be between " + min + " and " + max);
    }

    public DoubleValidation isNotBetween(Double min, Double max, String message) {
        return this.isNotBetween(min, max, () -> message);
    }

    public DoubleValidation isNotBetween(Double min, Double max, Supplier<String> message) {
        return this.assertFalse(this.getActual() >= min && this.getActual() <= max, message);
    }

    public DoubleValidation isGreaterThan(Double expected) {
        return this.isGreaterThan(expected, () -> "Expected value to be greater than " + expected);
    }

    public DoubleValidation isGreaterThan(Double expected, String message) {
        return this.isGreaterThan(expected, () -> message);
    }

    public DoubleValidation isGreaterThan(Double expected, Supplier<String> message) {
        return this.assertTrue(this.getActual() > expected, message);
    }

    public DoubleValidation isGreaterThanOrEqualTo(Double expected) {
        return this.isGreaterThanOrEqualTo(expected, () -> "Expected value to be greater than or equal to " + expected);
    }

    public DoubleValidation isGreaterThanOrEqualTo(Double expected, String message) {
        return this.isGreaterThanOrEqualTo(expected, () -> message);
    }

    public DoubleValidation isGreaterThanOrEqualTo(Double expected, Supplier<String> message) {
        return this.assertTrue(this.getActual() >= expected, message);
    }

    public DoubleValidation isLessThan(Double expected) {
        return this.isLessThan(expected, () -> "Expected value to be less than " + expected);
    }

    public DoubleValidation isLessThan(Double expected, String message) {
        return this.isLessThan(expected, () -> message);
    }

    public DoubleValidation isLessThan(Double expected, Supplier<String> message) {
        return this.assertTrue(this.getActual() < expected, message);
    }

    public DoubleValidation isLessThanOrEqualTo(Double expected) {
        return this.isLessThanOrEqualTo(expected, () -> "Expected value to be less than or equal to " + expected);
    }

    public DoubleValidation isLessThanOrEqualTo(Double expected, String message) {
        return this.isLessThanOrEqualTo(expected, () -> message);
    }

    public DoubleValidation isLessThanOrEqualTo(Double expected, Supplier<String> message) {
        return this.assertTrue(this.getActual() <= expected, message);
    }
}
