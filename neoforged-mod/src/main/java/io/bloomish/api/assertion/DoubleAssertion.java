package io.bloomish.api.assertion;

import java.util.function.Supplier;

public class DoubleAssertion extends Assertion<Double, DoubleAssertion> {
    protected DoubleAssertion(Double object) {
        super(object);
    }

    public DoubleAssertion isPositive() {
        return this.isPositive(() -> "Expected value to be positive");
    }

    public DoubleAssertion isPositive(Supplier<String> message) {
        return this.assertTrue(this.getActual() > 0, message);
    }

    public DoubleAssertion isNegative() {
        return this.isNegative(() -> "Expected value to be negative");
    }

    public DoubleAssertion isNegative(Supplier<String> message) {
        return this.assertTrue(this.getActual() < 0, message);
    }

    public DoubleAssertion isZero() {
        return this.isZero(() -> "Expected value to be zero");
    }

    public DoubleAssertion isZero(Supplier<String> message) {
        return this.assertTrue(this.getActual() == 0, message);
    }

    public DoubleAssertion isNotZero() {
        return this.isNotZero(() -> "Expected value not to be zero");
    }

    public DoubleAssertion isNotZero(Supplier<String> message) {
        return this.assertFalse(this.getActual() == 0, message);
    }

    public DoubleAssertion isBetween(Double min, Double max) {
        return this.isBetween(min, max, () -> "Expected value to be between " + min + " and " + max);
    }

    public DoubleAssertion isBetween(Double min, Double max, Supplier<String> message) {
        return this.assertTrue(this.getActual() >= min && this.getActual() <= max, message);
    }

    public DoubleAssertion isNotBetween(Double min, Double max) {
        return this.isNotBetween(min, max, () -> "Expected value not to be between " + min + " and " + max);
    }

    public DoubleAssertion isNotBetween(Double min, Double max, Supplier<String> message) {
        return this.assertFalse(this.getActual() >= min && this.getActual() <= max, message);
    }

    public DoubleAssertion isGreaterThan(Double expected) {
        return this.isGreaterThan(expected, () -> "Expected value to be greater than " + expected);
    }

    public DoubleAssertion isGreaterThan(Double expected, Supplier<String> message) {
        return this.assertTrue(this.getActual() > expected, message);
    }

    public DoubleAssertion isGreaterThanOrEqualTo(Double expected) {
        return this.isGreaterThanOrEqualTo(expected, () -> "Expected value to be greater than or equal to " + expected);
    }

    public DoubleAssertion isGreaterThanOrEqualTo(Double expected, Supplier<String> message) {
        return this.assertTrue(this.getActual() >= expected, message);
    }

    public DoubleAssertion isLessThan(Double expected) {
        return this.isLessThan(expected, () -> "Expected value to be less than " + expected);
    }

    public DoubleAssertion isLessThan(Double expected, Supplier<String> message) {
        return this.assertTrue(this.getActual() < expected, message);
    }

    public DoubleAssertion isLessThanOrEqualTo(Double expected) {
        return this.isLessThanOrEqualTo(expected, () -> "Expected value to be less than or equal to " + expected);
    }

    public DoubleAssertion isLessThanOrEqualTo(Double expected, Supplier<String> message) {
        return this.assertTrue(this.getActual() <= expected, message);
    }
}
