package io.bloomish.api.assertion;

import java.util.function.Supplier;

public class DoubleAssertion extends Assertion<Double, DoubleAssertion> {
    protected DoubleAssertion(Double object) {
        super(object);
    }

    public DoubleAssertion isPositive(Supplier<String> message) {
        return this.assertTrue(this.getObject() > 0, message);
    }

    public DoubleAssertion isNegative(Supplier<String> message) {
        return this.assertTrue(this.getObject() < 0, message);
    }

    public DoubleAssertion isZero(Supplier<String> message) {
        return this.assertTrue(this.getObject() == 0, message);
    }

    public DoubleAssertion isNotZero(Supplier<String> message) {
        return this.assertFalse(this.getObject() == 0, message);
    }

    public DoubleAssertion isBetween(Double min, Double max, Supplier<String> message) {
        return this.assertTrue(this.getObject() >= min && this.getObject() <= max, message);
    }

    public DoubleAssertion isNotBetween(Double min, Double max, Supplier<String> message) {
        return this.assertFalse(this.getObject() >= min && this.getObject() <= max, message);
    }

    public DoubleAssertion isGreaterThan(Double other, Supplier<String> message) {
        return this.assertTrue(this.getObject() > other, message);
    }

    public DoubleAssertion isGreaterThanOrEqualTo(Double other, Supplier<String> message) {
        return this.assertTrue(this.getObject() >= other, message);
    }

    public DoubleAssertion isLessThan(Double other, Supplier<String> message) {
        return this.assertTrue(this.getObject() < other, message);
    }

    public DoubleAssertion isLessThanOrEqualTo(Double other, Supplier<String> message) {
        return this.assertTrue(this.getObject() <= other, message);
    }
}
