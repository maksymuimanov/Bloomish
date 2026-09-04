# Layer Separation

Priority: critical

Scope: All modules

## Rule

MUST maintain clear separation between API layer, implementation layer, and example usage layer.

## Rationale

Layer separation enables independent evolution of components, makes the codebase testable, and prevents circular dependencies.

## Exceptions

None

## Verification

- API layer (neoforged-mod) must not depend on example layer
- Example layer may depend on API layer
- Implementation details must not leak into public API

---

# Single Responsibility

Priority: high

Scope: All classes

## Rule

MUST design classes with a single, well-defined responsibility.

## Rationale

Classes with single responsibility are easier to understand, test, and maintain.

## Exceptions

None

## Verification

- Check that each class has one clear purpose
- Verify that methods within a class are related to that purpose
- Ensure class name accurately reflects its responsibility

---

# Dependency Direction

Priority: critical

Scope: Module dependencies

## Rule

MUST ensure dependencies flow from higher-level modules to lower-level modules. Lower-level modules must not depend on higher-level modules.

## Rationale

Proper dependency direction prevents circular dependencies and maintains a clean architecture.

## Exceptions

None

## Verification

- Verify dependency graph is acyclic
- Check that API does not depend on implementation details
- Ensure example module depends only on API module

---

# Abstraction Over Implementation

Priority: high

Scope: API design

## Rule

MUST program to interfaces or abstract classes, not concrete implementations, in public APIs.

## Rationale

Abstraction allows flexibility in implementation and enables users to provide their own implementations.

## Exceptions

When the class is intentionally final and not meant to be extended

## Verification

- Check that public APIs use interfaces where appropriate
- Verify that concrete implementations are not exposed in public API signatures
- Ensure factory methods or builders are used for object creation

---

# Encapsulation

Priority: high

Scope: All classes

## Rule

MUST keep fields private and provide access through methods only when necessary.

## Rationale

Encapsulation protects internal state and allows the class to control access to its data.

## Exceptions

Immutable data classes or records where fields can be public final

## Verification

- Check that fields are private unless there's a specific reason
- Verify that getters/setters are used appropriately
- Ensure internal implementation details are not exposed

---

# Composition Over Inheritance

Priority: high

Scope: Class design

## Rule

SHOULD prefer composition over inheritance for code reuse.

## Rationale

Composition provides more flexibility and avoids the fragility of deep inheritance hierarchies.

## Exceptions

When inheritance clearly models an "is-a" relationship and the base class is designed for extension

## Verification

- Check if functionality can be achieved through composition
- Verify that inheritance is used only when it makes semantic sense
- Ensure inheritance hierarchies are shallow (typically 1-2 levels)
