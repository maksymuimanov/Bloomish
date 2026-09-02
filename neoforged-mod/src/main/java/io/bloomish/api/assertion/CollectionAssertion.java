package io.bloomish.api.assertion;

import io.bloomish.api.util.CollectionUtils;

import java.util.Collection;
import java.util.function.Supplier;

public class CollectionAssertion extends Assertion<Collection<?>, CollectionAssertion> {
    protected CollectionAssertion(Collection<?> object) {
        super(object);
    }

    public CollectionAssertion isEmpty(Supplier<String> message) {
        return this.assertTrue(CollectionUtils.isEmpty(this.getObject()), message);
    }

    public CollectionAssertion isNotEmpty(Supplier<String> message) {
        return this.assertFalse(CollectionUtils.isEmpty(this.getObject()), message);
    }

    public CollectionAssertion hasSize(int size, Supplier<String> message) {
        return this.assertTrue(this.getObject().size() == size, message);
    }

    public CollectionAssertion hasSizeGreaterThan(int size, Supplier<String> message) {
        return this.assertTrue(this.getObject().size() > size, message);
    }

    public CollectionAssertion hasSizeLessThan(int size, Supplier<String> message) {
        return this.assertTrue(this.getObject().size() < size, message);
    }

    public CollectionAssertion hasSizeBetween(int min, int max, Supplier<String> message) {
        return this.assertTrue(this.getObject().size() >= min && this.getObject().size() <= max, message);
    }

    public CollectionAssertion hasSizeNotBetween(int min, int max, Supplier<String> message) {
        return this.assertFalse(this.getObject().size() >= min && this.getObject().size() <= max, message);
    }

    public CollectionAssertion isContaining(Object object, Supplier<String> message) {
        return this.assertTrue(this.getObject().contains(object), message);
    }

    public CollectionAssertion isNotContaining(Object object, Supplier<String> message) {
        return this.assertFalse(this.getObject().contains(object), message);
    }
}
