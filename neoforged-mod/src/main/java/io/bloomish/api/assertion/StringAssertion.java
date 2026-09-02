package io.bloomish.api.assertion;

import io.bloomish.api.util.StringUtils;

import java.util.function.Supplier;

public class StringAssertion extends Assertion<String, StringAssertion> {
    protected StringAssertion(String object) {
        super(object);
    }

    public StringAssertion isEmpty(Supplier<String> message) {
        return this.assertTrue(StringUtils.isEmpty(this.getObject()), message);
    }

    public StringAssertion isNotEmpty(Supplier<String> message) {
        return this.assertFalse(StringUtils.isEmpty(this.getObject()), message);
    }

    public StringAssertion isBlank(Supplier<String> message) {
        return this.assertTrue(StringUtils.isBlank(this.getObject()), message);
    }

    public StringAssertion isNotBlank(Supplier<String> message) {
        return this.assertFalse(StringUtils.isBlank(this.getObject()), message);
    }

    public StringAssertion isUpperCase(Supplier<String> message) {
        return this.assertTrue(StringUtils.isUpperCase(this.getObject()), message);
    }

    public StringAssertion isLowerCase(Supplier<String> message) {
        return this.assertTrue(StringUtils.isLowerCase(this.getObject()), message);
    }

    public StringAssertion isEqualIgnoreCase(String other, Supplier<String> message) {
        return this.assertTrue(StringUtils.isEqualIgnoreCase(this.getObject(), other), message);
    }

    public StringAssertion isContaining(String other, Supplier<String> message) {
        return this.assertTrue(this.getObject().contains(other), message);
    }

    public StringAssertion isNotContaining(String other, Supplier<String> message) {
        return this.assertFalse(this.getObject().contains(other), message);
    }

    public StringAssertion isStartingWith(String other, Supplier<String> message) {
        return this.assertTrue(this.getObject().startsWith(other), message);
    }

    public StringAssertion isNotStartingWith(String other, Supplier<String> message) {
        return this.assertFalse(this.getObject().startsWith(other), message);
    }

    public StringAssertion isEndingWith(String other, Supplier<String> message) {
        return this.assertTrue(this.getObject().endsWith(other), message);
    }

    public StringAssertion isNotEndingWith(String other, Supplier<String> message) {
        return this.assertFalse(this.getObject().endsWith(other), message);
    }
}
