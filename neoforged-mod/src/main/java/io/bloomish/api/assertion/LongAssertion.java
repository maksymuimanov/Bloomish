package io.bloomish.api.assertion;

import java.util.function.Supplier;

public class LongAssertion extends Assertion<Long, LongAssertion> {
    protected LongAssertion(Long object) {
        super(object);
    }

    public LongAssertion isPositive() {
        return this.isPositive(() -> "Expected value to be positive");
    }

    public LongAssertion isPositive(Supplier<String> message) {
        return this.assertTrue(this.getActual() > 0, message);
    }

    public LongAssertion isNegative() {
        return this.isNegative(() -> "Expected value to be negative");
    }

    public LongAssertion isNegative(Supplier<String> message) {
        return this.assertTrue(this.getActual() < 0, message);
    }

    public LongAssertion isZero() {
        return this.isZero(() -> "Expected value to be zero");
    }

    public LongAssertion isZero(Supplier<String> message) {
        return this.assertTrue(this.getActual() == 0, message);
    }

    public LongAssertion isNotZero() {
        return this.isNotZero(() -> "Expected value not to be zero");
    }

    public LongAssertion isNotZero(Supplier<String> message) {
        return this.assertFalse(this.getActual() == 0, message);
    }

    public LongAssertion isBetween(Long min, Long max) {
        return this.isBetween(min, max, () -> "Expected value to be between " + min + " and " + max);
    }

    public LongAssertion isBetween(Long min, Long max, Supplier<String> message) {
        return this.assertTrue(this.getActual() >= min && this.getActual() <= max, message);
    }

    public LongAssertion isNotBetween(Long min, Long max) {
        return this.isNotBetween(min, max, () -> "Expected value not to be between " + min + " and " + max);
    }

    public LongAssertion isNotBetween(Long min, Long max, Supplier<String> message) {
        return this.assertFalse(this.getActual() >= min && this.getActual() <= max, message);
    }

    public LongAssertion isGreaterThan(Long expected) {
        return this.isGreaterThan(expected, () -> "Expected value to be greater than " + expected);
    }

    public LongAssertion isGreaterThan(Long expected, Supplier<String> message) {
        return this.assertTrue(this.getActual() > expected, message);
    }

    public LongAssertion isGreaterThanOrEqualTo(Long expected) {
        return this.isGreaterThanOrEqualTo(expected, () -> "Expected value to be greater than or equal to " + expected);
    }

    public LongAssertion isGreaterThanOrEqualTo(Long expected, Supplier<String> message) {
        return this.assertTrue(this.getActual() >= expected, message);
    }

    public LongAssertion isLessThan(Long expected) {
        return this.isLessThan(expected, () -> "Expected value to be less than " + expected);
    }

    public LongAssertion isLessThan(Long expected, Supplier<String> message) {
        return this.assertTrue(this.getActual() < expected, message);
    }

    public LongAssertion isLessThanOrEqualTo(Long expected) {
        return this.isLessThanOrEqualTo(expected, () -> "Expected value to be less than or equal to " + expected);
    }

    public LongAssertion isLessThanOrEqualTo(Long expected, Supplier<String> message) {
        return this.assertTrue(this.getActual() <= expected, message);
    }
}
