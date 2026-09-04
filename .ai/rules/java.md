# Java Version

Priority: critical

Scope: All code

## Rule

MUST use the Java version specified in gradle.properties. Do not use features from newer Java versions.

## Rationale

The project must compile and run on the target Java version specified in the build configuration.

## Exceptions

None

## Verification

- Check gradle.properties for the target Java version
- Verify that no language features from newer versions are used
- Ensure that APIs are compatible with the target version

---

# Stream API Usage

Priority: medium

Scope: Collection processing

## Rule

SHOULD use Stream API for collection operations when it improves readability, but not for simple operations.

## Rationale

Streams can make code more readable for complex operations but add overhead for simple ones.

## Exceptions

Performance-critical code where loops are measurably faster

## Verification

- Check that streams are used appropriately for the complexity of the operation
- Verify that stream operations are not unnecessarily complex
- Ensure that streams are not used when a simple loop would be clearer

---


# Try-with-Resources

Priority: high

Scope: All resource management

## Rule

MUST use try-with-resources for all AutoCloseable resources.

## Rationale

Try-with-resources ensures resources are properly closed even when exceptions occur.

## Exceptions

None

## Verification

- Check that all streams, files, and other closeable resources use try-with-resources
- Verify that resources are not manually closed when try-with-resources could be used

---

# Record Classes

Priority: medium

Scope: Data carrier classes

## Rule

SHOULD use record classes for immutable data carriers.

## Rationale

Records provide a concise syntax for immutable data classes with automatically generated methods.

## Exceptions

When the class needs mutable state or custom behavior beyond what records provide

## Verification

- Check that simple data carrier classes use records
- Verify that records are used for immutable data
- Ensure that records are not used when a class is more appropriate

---

# Switch Expressions

Priority: medium

Scope: Switch statements

## Rule

SHOULD use switch expressions when they improve readability and the Java version supports them.

## Rationale

Switch expressions are more concise and can be used as expressions.

## Exceptions

When the traditional switch statement is clearer for the specific case

## Verification

- Check that switch expressions are used when appropriate
- Verify that the Java version supports switch expressions
- Ensure that switch expressions don't reduce readability

---

# Var Keyword

Priority: low

Scope: Local variable declarations

## Rule

MAY use var for local variables when the type is obvious from the initializer.

## Rationale

Var can reduce verbosity when the type is clear, but can reduce readability when the type is not obvious.

## Exceptions

When the type is not obvious from the initializer

## Verification

- Check that var is used only when the type is obvious
- Verify that var does not reduce code readability
- Ensure that var is not used for fields or method parameters

---

# Null Safety

Priority: high

Scope: All code

## Rule

MUST explicitly handle null values. Do not assume values are non-null unless documented.

## Rationale

NullPointerException is a common source of bugs. Explicit null handling makes code more robust.

## Exceptions

When using @NonNull/@Nullable annotations and static analysis to enforce null safety

## Verification

- Check that method parameters that can be null are documented
- Verify that null checks are performed before dereferencing
- Ensure that methods that return null document this fact
