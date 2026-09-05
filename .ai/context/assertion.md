# Context: Assertion API

## Purpose

Provides a fluent assertion library for runtime validation and testing within the Bloomish framework.

## Scope

Applies to `io.bloomish.api.assertion` package.

## Overview

The assertion API provides a fluent, chainable interface for validating object states and conditions at runtime. It follows a builder pattern with type-safe assertions that throw `AssertionError` on failure.

## Structure

**Core Classes:**

- **Assertion<T, A>**: Base generic assertion class with common validation methods
  - Type checking: `isTypeOf()`, `isNotTypeOf()`
  - Equality: `isEqual()`, `isNotEqual()`, `isSame()`, `isNotSame()`
  - Null checks: `isNull()`, `isNotNull()`
  - Boolean conditions: `assertTrue()`, `assertFalse()`

- **Assertions**: Static factory class for创建 assertion instances
  - `assertThat(T)` - Generic object assertion
  - `assertThatMod(String)` - Mod-specific assertion
  - `assertThatString(String)` - String assertion
  - `assertThatLong(Number)` - Long number assertion
  - `assertThatDouble(Number)` - Double number assertion
  - `assertThatCollection(Collection<?>)` - Collection assertion

**Specialized Assertions:**

- **StringAssertion**: Extends Assertion with string-specific validations
  - Empty/blank: `isEmpty()`, `isNotEmpty()`, `isBlank()`, `isNotBlank()`
  - Case: `isUpperCase()`, `isLowerCase()`
  - Comparison: `isEqualIgnoreCase()`
  - Containment: `isContaining()`, `isNotContaining()`
  - Prefix/suffix: `isStartingWith()`, `isNotStartingWith()`, `isEndingWith()`, `isNotEndingWith()`

- **CollectionAssertion**: Extends Assertion with collection-specific validations
  - Size: `hasSize()`, `hasSizeGreaterThan()`, `hasSizeLessThan()`, `hasSizeBetween()`, `hasSizeNotBetween()`
  - Containment: `isContaining()`, `isNotContaining()`

- **ModAssertion**: Extends Assertion with mod-specific validations
  - Load state: `isLoaded()`, `isNotLoaded()`
  - Identity: `isCurrent()`, `isNotCurrent()`

- **LongAssertion**: Extends Assertion for long number validations
- **DoubleAssertion**: Extends Assertion for double number validations

## Conventions

- All assertion methods return `this` for method chaining
- Each assertion has two overloads: one with default message, one with custom `Supplier<String>` message
- Failed assertions throw `AssertionError` with the provided message
- Assertions use utility classes from `io.bloomish.api.util` (StringUtils, CollectionUtils) where appropriate

## Dependencies

- `io.bloomish.api.util.StringUtils` - For string validation helpers
- `io.bloomish.api.util.CollectionUtils` - For collection validation helpers
- `io.bloomish.api.engine.context.ModContext` - For mod identity checks
- `net.neoforged.fml.ModList` - For mod load state checking

## Constraints

- Assertions are designed for runtime validation, not compile-time checking
- Custom messages are provided as `Supplier<String>` for lazy evaluation
- All assertion failures are fatal (throw AssertionError)

## Examples

**Basic object assertion:**
```java
assertThat(myObject).isNotNull().isTypeOf(MyClass.class);
```

**String assertion:**
```java
assertThatString(myString)
    .isNotEmpty()
    .isStartingWith("prefix")
    .isEndingWith("suffix");
```

**Collection assertion:**
```java
assertThatCollection(myList)
    .isNotEmpty()
    .hasSizeGreaterThan(5)
    .isContaining(expectedItem);
```

**Mod assertion:**
```java
assertThatMod("othermod")
    .isLoaded()
    .isNotCurrent();
```

**Custom error messages:**
```java
assertThat(value)
    .isEqual(expected, () -> "Value mismatch: got " + value + ", expected " + expected);
```

## Source of Truth

- `io.bloomish.api.assertion.Assertion` - Base assertion implementation
- `io.bloomish.api.assertion.Assertions` - Static factory methods
- Specialized assertion classes in the same package
