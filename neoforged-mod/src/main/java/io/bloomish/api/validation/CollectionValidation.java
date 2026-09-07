package io.bloomish.api.validation;

import io.bloomish.api.util.CollectionUtils;

import java.util.Collection;
import java.util.function.Supplier;

public class CollectionValidation extends Validation<Collection<?>, CollectionValidation> {
    protected CollectionValidation(Collection<?> object) {
        super(object);
    }

    public CollectionValidation isEmpty() {
        return this.isEmpty(() -> "Expected collection to be empty");
    }

    public CollectionValidation isEmpty(String message) {
        return this.isEmpty(() -> message);
    }

    public CollectionValidation isEmpty(Supplier<String> message) {
        return this.isTrue(CollectionUtils.isEmpty(this.getActual()), message);
    }

    public CollectionValidation isNotEmpty() {
        return this.isNotEmpty(() -> "Expected collection not to be empty");
    }

    public CollectionValidation isNotEmpty(String message) {
        return this.isNotEmpty(() -> message);
    }

    public CollectionValidation isNotEmpty(Supplier<String> message) {
        return this.isFalse(CollectionUtils.isEmpty(this.getActual()), message);
    }

    public CollectionValidation hasSize(int size) {
        return this.hasSize(size, () -> "Expected collection to have size " + size);
    }

    public CollectionValidation hasSize(int size, String message) {
        return this.hasSize(size, () -> message);
    }

    public CollectionValidation hasSize(int size, Supplier<String> message) {
        return this.isTrue(this.getActual().size() == size, message);
    }

    public CollectionValidation hasSizeGreaterThan(int size) {
        return this.hasSizeGreaterThan(size, () -> "Expected collection size to be greater than " + size);
    }

    public CollectionValidation hasSizeGreaterThan(int size, String message) {
        return this.hasSizeGreaterThan(size, () -> message);
    }

    public CollectionValidation hasSizeGreaterThan(int size, Supplier<String> message) {
        return this.isTrue(this.getActual().size() > size, message);
    }

    public CollectionValidation hasSizeLessThan(int size) {
        return this.hasSizeLessThan(size, () -> "Expected collection size to be less than " + size);
    }

    public CollectionValidation hasSizeLessThan(int size, String message) {
        return this.hasSizeLessThan(size, () -> message);
    }

    public CollectionValidation hasSizeLessThan(int size, Supplier<String> message) {
        return this.isTrue(this.getActual().size() < size, message);
    }

    public CollectionValidation hasSizeBetween(int min, int max) {
        return this.hasSizeBetween(min, max, () -> "Expected collection size to be between " + min + " and " + max);
    }

    public CollectionValidation hasSizeBetween(int min, int max, String message) {
        return this.hasSizeBetween(min, max, () -> message);
    }

    public CollectionValidation hasSizeBetween(int min, int max, Supplier<String> message) {
        return this.isTrue(this.getActual().size() >= min && this.getActual().size() <= max, message);
    }

    public CollectionValidation hasSizeNotBetween(int min, int max) {
        return this.hasSizeNotBetween(min, max, () -> "Expected collection size not to be between " + min + " and " + max);
    }

    public CollectionValidation hasSizeNotBetween(int min, int max, String message) {
        return this.hasSizeNotBetween(min, max, () -> message);
    }

    public CollectionValidation hasSizeNotBetween(int min, int max, Supplier<String> message) {
        return this.isFalse(this.getActual().size() >= min && this.getActual().size() <= max, message);
    }

    public CollectionValidation isContaining(Object expected) {
        return this.isContaining(expected, () -> "Expected collection to contain " + expected);
    }

    public CollectionValidation isContaining(Object expected, String message) {
        return this.isContaining(expected, () -> message);
    }

    public CollectionValidation isContaining(Object expected, Supplier<String> message) {
        return this.isTrue(this.getActual().contains(expected), message);
    }

    public CollectionValidation isNotContaining(Object expected) {
        return this.isNotContaining(expected, () -> "Expected collection not to contain " + expected);
    }

    public CollectionValidation isNotContaining(Object expected, String message) {
        return this.isNotContaining(expected, () -> message);
    }

    public CollectionValidation isNotContaining(Object expected, Supplier<String> message) {
        return this.isFalse(this.getActual().contains(expected), message);
    }
}
