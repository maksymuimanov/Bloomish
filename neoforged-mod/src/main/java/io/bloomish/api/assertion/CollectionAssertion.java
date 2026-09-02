package io.bloomish.api.assertion;

import io.bloomish.api.util.CollectionUtils;

import java.util.Collection;
import java.util.function.Supplier;

public class CollectionAssertion extends Assertion<Collection<?>, CollectionAssertion> {
    protected CollectionAssertion(Collection<?> object) {
        super(object);
    }

    public CollectionAssertion isEmpty() {
        return this.isEmpty(() -> "Expected collection to be empty");
    }

    public CollectionAssertion isEmpty(Supplier<String> message) {
        return this.assertTrue(CollectionUtils.isEmpty(this.getActual()), message);
    }

    public CollectionAssertion isNotEmpty() {
        return this.isNotEmpty(() -> "Expected collection not to be empty");
    }

    public CollectionAssertion isNotEmpty(Supplier<String> message) {
        return this.assertFalse(CollectionUtils.isEmpty(this.getActual()), message);
    }

    public CollectionAssertion hasSize(int size) {
        return this.hasSize(size, () -> "Expected collection to have size " + size);
    }

    public CollectionAssertion hasSize(int size, Supplier<String> message) {
        return this.assertTrue(this.getActual().size() == size, message);
    }

    public CollectionAssertion hasSizeGreaterThan(int size) {
        return this.hasSizeGreaterThan(size, () -> "Expected collection size to be greater than " + size);
    }

    public CollectionAssertion hasSizeGreaterThan(int size, Supplier<String> message) {
        return this.assertTrue(this.getActual().size() > size, message);
    }

    public CollectionAssertion hasSizeLessThan(int size) {
        return this.hasSizeLessThan(size, () -> "Expected collection size to be less than " + size);
    }

    public CollectionAssertion hasSizeLessThan(int size, Supplier<String> message) {
        return this.assertTrue(this.getActual().size() < size, message);
    }

    public CollectionAssertion hasSizeBetween(int min, int max) {
        return this.hasSizeBetween(min, max, () -> "Expected collection size to be between " + min + " and " + max);
    }

    public CollectionAssertion hasSizeBetween(int min, int max, Supplier<String> message) {
        return this.assertTrue(this.getActual().size() >= min && this.getActual().size() <= max, message);
    }

    public CollectionAssertion hasSizeNotBetween(int min, int max) {
        return this.hasSizeNotBetween(min, max, () -> "Expected collection size not to be between " + min + " and " + max);
    }

    public CollectionAssertion hasSizeNotBetween(int min, int max, Supplier<String> message) {
        return this.assertFalse(this.getActual().size() >= min && this.getActual().size() <= max, message);
    }

    public CollectionAssertion isContaining(Object expected) {
        return this.isContaining(expected, () -> "Expected collection to contain " + expected);
    }

    public CollectionAssertion isContaining(Object expected, Supplier<String> message) {
        return this.assertTrue(this.getActual().contains(expected), message);
    }

    public CollectionAssertion isNotContaining(Object expected) {
        return this.isNotContaining(expected, () -> "Expected collection not to contain " + expected);
    }

    public CollectionAssertion isNotContaining(Object expected, Supplier<String> message) {
        return this.assertFalse(this.getActual().contains(expected), message);
    }
}
