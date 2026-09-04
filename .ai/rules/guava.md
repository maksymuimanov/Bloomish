# Guava Usage

Priority: high

Scope: All code

## Rule

MUST use Guava utilities when they provide clear benefits over Java standard library equivalents.

## Rationale

Guava provides well-tested, efficient utilities that improve code quality and readability.

## Exceptions

When the Java standard library provides an equivalent solution in the target Java version

## Verification

- Check that Guava is used for collections utilities (ImmutableList, Maps, etc.)
- Verify that Guava's Preconditions are used for argument validation
- Ensure that Guava utilities are not duplicated with custom implementations

---

# Immutable Collections

Priority: high

Scope: Collection fields and return values

## Rule

SHOULD use Guava's immutable collections (ImmutableList, ImmutableSet, ImmutableMap) for immutable data.

## Rationale

Immutable collections provide guarantees of immutability and are more efficient than defensive copying.

## Exceptions

When Java's unmodifiable collections are sufficient and Guava is not available

## Verification

- Check that immutable collections are used for constant data
- Verify that immutable collections are returned from methods that should not be modified
- Ensure that mutable collections are not used when immutability is desired

---

# Preconditions

Priority: high

Scope: Method parameter validation

## Rule

SHOULD use Guava's Preconditions (checkNotNull, checkArgument, checkState) for validation.

## Rationale

Preconditions provide clear, concise validation with descriptive error messages.

## Exceptions

When custom validation logic is needed that Preconditions cannot handle

## Verification

- Check that Preconditions are used for null checks
- Verify that Preconditions are used for argument validation
- Ensure that error messages are descriptive

---

# Optional vs Guava Optional

Priority: critical

Scope: Optional usage

## Rule

MUST use java.util.Optional, not Guava's Optional.

## Rationale

Java 8+ provides java.util.Optional as the standard. Guava's Optional is deprecated in favor of it.

## Exceptions

Legacy code that cannot be updated

## Verification

- Check that java.util.Optional is imported and used
- Verify that Guava's Optional is not used
- Ensure that Optional is used consistently throughout the codebase

---

# Strings

Priority: medium

Scope: String manipulation

## Rule

SHOULD use Guava's Strings class for common string operations when it improves readability.

## Rationale

Guava's Strings class provides utilities like isNullOrEmpty, emptyToNull, nullToEmpty.

## Exceptions

When the operation is simple enough that standard library methods are clearer

## Verification

- Check that Strings.isNullOrEmpty is used for null/empty checks
- Verify that Guava string utilities are used when appropriate
- Ensure that string manipulation is clear and readable
