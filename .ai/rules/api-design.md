# Immutability

Priority: high

Scope: Public API classes

## Rule

MUST design public API classes as immutable where possible. Follow Effective Java Item 17.

## Rationale

Immutable objects are simple, thread-safe, and can be shared freely without defensive copying.

## Exceptions

Objects that represent mutable state (e.g., builders, configuration objects that must be modified)

## Verification

- Check that fields are final
- Verify that methods don't modify state
- Ensure defensive copies are made of mutable fields in constructors and getters

---

# Builder Pattern

Priority: high

Scope: Complex objects with many parameters

## Rule

SHOULD use the Builder pattern for objects with multiple optional parameters. Follow Effective Java Item 2.

## Rationale

Builders make code readable and handle optional parameters gracefully compared to telescoping constructors.

## Exceptions

Simple objects with few required parameters

## Verification

- Check that builder has a static factory method or constructor
- Verify that builder has fluent interface (chaining methods)
- Ensure build() method validates state before returning the object

---

# Static Factory Methods

Priority: high

Scope: Object creation

## Rule

SHOULD prefer static factory methods over constructors. Follow Effective Java Item 1.

## Rationale

Static factory methods have names, can return cached instances, and can return subtypes.

## Exceptions

When constructors are clearly the better choice for the specific use case

## Verification

- Check for named static factory methods (e.g., valueOf, of, getInstance)
- Verify that constructors are often private when factory methods are used
- Ensure factory methods return appropriate types

---

# Optional Return Values

Priority: high

Scope: Methods that may not return a value

## Rule

MUST use Optional<T> for return values that may be absent, not null. Follow Effective Java Item 55.

## Rationale

Optional clearly documents that a value may be absent and forces callers to handle that case.

## Exceptions

Performance-critical code where Optional overhead is unacceptable

## Verification

- Check that methods don't return null to indicate absence
- Verify that Optional is used appropriately
- Ensure callers handle the empty case

---

# Method Parameters

Priority: high

Scope: Public API methods

## Rule

MUST minimize the number of parameters. Follow Clean Code principles.

## Rationale

Methods with many parameters are hard to understand and use.

## Exceptions

None

## Verification

- Check that methods have 3 or fewer parameters when possible
- Verify that parameter objects are used for related parameters
- Ensure boolean parameters are avoided (use enums instead)

---

# Interface Segregation

Priority: high

Scope: Interface design

## Rule

MUST keep interfaces focused and small. Follow Interface Segregation Principle.

## Rationale

Clients should not be forced to depend on methods they don't use.

## Exceptions

None

## Verification

- Check that interfaces have cohesive methods
- Verify that interfaces are not bloated with unrelated methods
- Ensure clients can implement only the methods they need

---

# Defensive Copies

Priority: critical

Scope: Methods accepting or returning mutable objects

## Rule

MUST make defensive copies of mutable parameters and return values. Follow Effective Java Item 50.

## Rationale

Defensive copies prevent internal state from being corrupted by external references.

## Exceptions

When the class explicitly trusts the caller (documented clearly)

## Verification

- Check that constructors copy mutable parameters
- Verify that getters return copies of mutable fields
- Ensure that input collections are copied before storing

---

# Method Naming

Priority: high

Scope: All public methods

## Rule

MUST use clear, descriptive method names that follow Clean Code principles.

## Rationale

Good method names make code self-documenting and reduce the need for comments.

## Exceptions

None

## Verification

- Check that method names describe what they do, not how
- Verify that boolean methods start with is/has/can/should
- Ensure methods don't have misleading names

---

# Avoid Overloading

Priority: medium

Scope: Public API

## Rule

SHOULD avoid overloading methods with different parameter types that could cause confusion. Follow Effective Java Item 52.

## Rationale

Overloading can lead to unexpected behavior and make code hard to understand.

## Exceptions

When overloading is clear and unambiguous (e.g., different numbers of parameters)

## Verification

- Check that overloaded methods are not confusing
- Verify that the compiler can resolve the correct method unambiguously
- Ensure that overloads don't violate the principle of least surprise

---

# Generics

Priority: high

Scope: Generic classes and methods

## Rule

MUST use generics properly with appropriate bounds. Follow Effective Java Items 26-33.

## Rationale

Generics provide type safety and eliminate casts when used correctly.

## Exceptions

When using legacy code that doesn't support generics

## Verification

- Check that raw types are not used
- Verify that generic type parameters have meaningful names (T, E, K, V, etc.)
- Ensure that wildcards (? extends, ? super) are used appropriately
