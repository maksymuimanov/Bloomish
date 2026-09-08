package io.bloomish.api.validation;

import io.bloomish.api.util.StringUtils;

import java.util.function.Supplier;

public class StringValidation extends Validation<String, StringValidation> {
    protected StringValidation(String object) {
        super(object);
    }

    public StringValidation isEmpty() {
        return this.isEmpty(() -> "Expected string to be empty");
    }

    public StringValidation isEmpty(String message) {
        return this.isEmpty(() -> message);
    }

    public StringValidation isEmpty(Supplier<String> message) {
        return this.isCondition(StringUtils::isEmpty, message);
    }

    public StringValidation isNotEmpty() {
        return this.isNotEmpty(() -> "Expected string not to be empty");
    }

    public StringValidation isNotEmpty(String message) {
        return this.isNotEmpty(() -> message);
    }

    public StringValidation isNotEmpty(Supplier<String> message) {
        return this.isNotCondition(StringUtils::isEmpty, message);
    }

    public StringValidation isBlank() {
        return this.isBlank(() -> "Expected string to be blank");
    }

    public StringValidation isBlank(String message) {
        return this.isBlank(() -> message);
    }

    public StringValidation isBlank(Supplier<String> message) {
        return this.isCondition(StringUtils::isBlank, message);
    }

    public StringValidation isNotBlank() {
        return this.isNotBlank(() -> "Expected string not to be blank");
    }

    public StringValidation isNotBlank(String message) {
        return this.isNotBlank(() -> message);
    }

    public StringValidation isNotBlank(Supplier<String> message) {
        return this.isNotCondition(StringUtils::isBlank, message);
    }

    public StringValidation isUpperCase() {
        return this.isUpperCase(() -> "Expected string to be uppercase");
    }

    public StringValidation isUpperCase(String message) {
        return this.isUpperCase(() -> message);
    }

    public StringValidation isUpperCase(Supplier<String> message) {
        return this.isCondition(StringUtils::isUpperCase, message);
    }

    public StringValidation isLowerCase() {
        return this.isLowerCase(() -> "Expected string to be lowercase");
    }

    public StringValidation isLowerCase(String message) {
        return this.isLowerCase(() -> message);
    }

    public StringValidation isLowerCase(Supplier<String> message) {
        return this.isCondition(StringUtils::isLowerCase, message);
    }

    public StringValidation isEqualIgnoreCase(String expected) {
        return this.isEqualIgnoreCase(expected, () -> "Expected " + this.getActual() + " to equal " + expected + " ignoring case");
    }

    public StringValidation isEqualIgnoreCase(String expected, String message) {
        return this.isEqualIgnoreCase(expected, () -> message);
    }

    public StringValidation isEqualIgnoreCase(String expected, Supplier<String> message) {
        return this.isCondition(actual -> StringUtils.isEqualIgnoreCase(actual, expected), message);
    }

    public StringValidation isContaining(String expected) {
        return this.isContaining(expected, () -> "Expected string to contain " + expected);
    }

    public StringValidation isContaining(String expected, String message) {
        return this.isContaining(expected, () -> message);
    }

    public StringValidation isContaining(String expected, Supplier<String> message) {
        return this.isCondition(actual -> actual.contains(expected), message);
    }

    public StringValidation isNotContaining(String expected) {
        return this.isNotContaining(expected, () -> "Expected string not to contain " + expected);
    }

    public StringValidation isNotContaining(String expected, String message) {
        return this.isNotContaining(expected, () -> message);
    }

    public StringValidation isNotContaining(String expected, Supplier<String> message) {
        return this.isNotCondition(actual -> actual.contains(expected), message);
    }

    public StringValidation isStartingWith(String expected) {
        return this.isStartingWith(expected, () -> "Expected string to start with " + expected);
    }

    public StringValidation isStartingWith(String expected, String message) {
        return this.isStartingWith(expected, () -> message);
    }

    public StringValidation isStartingWith(String expected, Supplier<String> message) {
        return this.isCondition(actual -> actual.startsWith(expected), message);
    }

    public StringValidation isNotStartingWith(String expected) {
        return this.isNotStartingWith(expected, () -> "Expected string not to start with " + expected);
    }

    public StringValidation isNotStartingWith(String expected, String message) {
        return this.isNotStartingWith(expected, () -> message);
    }

    public StringValidation isNotStartingWith(String expected, Supplier<String> message) {
        return this.isNotCondition(actual -> actual.startsWith(expected), message);
    }

    public StringValidation isEndingWith(String expected) {
        return this.isEndingWith(expected, () -> "Expected string to end with " + expected);
    }

    public StringValidation isEndingWith(String expected, String message) {
        return this.isEndingWith(expected, () -> message);
    }

    public StringValidation isEndingWith(String expected, Supplier<String> message) {
        return this.isCondition(actual -> actual.endsWith(expected), message);
    }

    public StringValidation isNotEndingWith(String expected) {
        return this.isNotEndingWith(expected, () -> "Expected string not to end with " + expected);
    }

    public StringValidation isNotEndingWith(String expected, String message) {
        return this.isNotEndingWith(expected, () -> message);
    }

    public StringValidation isNotEndingWith(String expected, Supplier<String> message) {
        return this.isNotCondition(actual -> actual.endsWith(expected), message);
    }
}
