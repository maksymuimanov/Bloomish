package io.bloomish.api.assertion;

import java.util.function.Supplier;

public class LongAssertion extends Assertion<Long, LongAssertion> {
    protected LongAssertion(Long object) {
        super(object);
    }

    public LongAssertion isPositive(Supplier<String> message) {
        return this.assertTrue(this.getObject() > 0, message);
    }

    public LongAssertion isNegative(Supplier<String> message) {
        return this.assertTrue(this.getObject() < 0, message);
    }

    public LongAssertion isZero(Supplier<String> message) {
        return this.assertTrue(this.getObject() == 0, message);
    }

    public LongAssertion isNotZero(Supplier<String> message) {
        return this.assertFalse(this.getObject() == 0, message);
    }

    public LongAssertion isBetween(Long min, Long max, Supplier<String> message) {
        return this.assertTrue(this.getObject() >= min && this.getObject() <= max, message);
    }

    public LongAssertion isNotBetween(Long min, Long max, Supplier<String> message) {
        return this.assertFalse(this.getObject() >= min && this.getObject() <= max, message);
    }

    public LongAssertion isGreaterThan(Long other, Supplier<String> message) {
        return this.assertTrue(this.getObject() > other, message);
    }

    public LongAssertion isGreaterThanOrEqualTo(Long other, Supplier<String> message) {
        return this.assertTrue(this.getObject() >= other, message);
    }

    public LongAssertion isLessThan(Long other, Supplier<String> message) {
        return this.assertTrue(this.getObject() < other, message);
    }

    public LongAssertion isLessThanOrEqualTo(Long other, Supplier<String> message) {
        return this.assertTrue(this.getObject() <= other, message);
    }
}
