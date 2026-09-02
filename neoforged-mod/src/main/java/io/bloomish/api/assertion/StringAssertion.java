package io.bloomish.api.assertion;

import io.bloomish.api.util.StringUtils;

import java.util.function.Supplier;

public class StringAssertion extends Assertion<String, StringAssertion> {
    protected StringAssertion(String object) {
        super(object);
    }

    public StringAssertion isEmpty() {
        return this.isEmpty(() -> "Expected string to be empty");
    }

    public StringAssertion isEmpty(Supplier<String> message) {
        return this.assertTrue(StringUtils.isEmpty(this.getActual()), message);
    }

    public StringAssertion isNotEmpty() {
        return this.isNotEmpty(() -> "Expected string not to be empty");
    }

    public StringAssertion isNotEmpty(Supplier<String> message) {
        return this.assertFalse(StringUtils.isEmpty(this.getActual()), message);
    }

    public StringAssertion isBlank() {
        return this.isBlank(() -> "Expected string to be blank");
    }

    public StringAssertion isBlank(Supplier<String> message) {
        return this.assertTrue(StringUtils.isBlank(this.getActual()), message);
    }

    public StringAssertion isNotBlank() {
        return this.isNotBlank(() -> "Expected string not to be blank");
    }

    public StringAssertion isNotBlank(Supplier<String> message) {
        return this.assertFalse(StringUtils.isBlank(this.getActual()), message);
    }

    public StringAssertion isUpperCase() {
        return this.isUpperCase(() -> "Expected string to be uppercase");
    }

    public StringAssertion isUpperCase(Supplier<String> message) {
        return this.assertTrue(StringUtils.isUpperCase(this.getActual()), message);
    }

    public StringAssertion isLowerCase() {
        return this.isLowerCase(() -> "Expected string to be lowercase");
    }

    public StringAssertion isLowerCase(Supplier<String> message) {
        return this.assertTrue(StringUtils.isLowerCase(this.getActual()), message);
    }

    public StringAssertion isEqualIgnoreCase(String expected) {
        return this.isEqualIgnoreCase(expected, () -> "Expected " + this.getActual() + " to equal " + expected + " ignoring case");
    }

    public StringAssertion isEqualIgnoreCase(String expected, Supplier<String> message) {
        return this.assertTrue(StringUtils.isEqualIgnoreCase(this.getActual(), expected), message);
    }

    public StringAssertion isContaining(String expected) {
        return this.isContaining(expected, () -> "Expected string to contain " + expected);
    }

    public StringAssertion isContaining(String expected, Supplier<String> message) {
        return this.assertTrue(this.getActual().contains(expected), message);
    }

    public StringAssertion isNotContaining(String expected) {
        return this.isNotContaining(expected, () -> "Expected string not to contain " + expected);
    }

    public StringAssertion isNotContaining(String expected, Supplier<String> message) {
        return this.assertFalse(this.getActual().contains(expected), message);
    }

    public StringAssertion isStartingWith(String expected) {
        return this.isStartingWith(expected, () -> "Expected string to start with " + expected);
    }

    public StringAssertion isStartingWith(String expected, Supplier<String> message) {
        return this.assertTrue(this.getActual().startsWith(expected), message);
    }

    public StringAssertion isNotStartingWith(String expected) {
        return this.isNotStartingWith(expected, () -> "Expected string not to start with " + expected);
    }

    public StringAssertion isNotStartingWith(String expected, Supplier<String> message) {
        return this.assertFalse(this.getActual().startsWith(expected), message);
    }

    public StringAssertion isEndingWith(String expected) {
        return this.isEndingWith(expected, () -> "Expected string to end with " + expected);
    }

    public StringAssertion isEndingWith(String expected, Supplier<String> message) {
        return this.assertTrue(this.getActual().endsWith(expected), message);
    }

    public StringAssertion isNotEndingWith(String expected) {
        return this.isNotEndingWith(expected, () -> "Expected string not to end with " + expected);
    }

    public StringAssertion isNotEndingWith(String expected, Supplier<String> message) {
        return this.assertFalse(this.getActual().endsWith(expected), message);
    }
}
