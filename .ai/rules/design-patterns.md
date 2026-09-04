# Factory Pattern

Priority: medium

Scope: Object creation

## Rule

SHOULD use the Factory pattern when object creation logic is complex or needs to be centralized.

## Rationale

Factory pattern encapsulates creation logic, reduces coupling, and makes it easier to add new types.

## Exceptions

Simple object creation that doesn't require complex logic

## Verification

- Check that factory methods/classes are used for complex creation logic
- Verify that factories are used when creation needs to be centralized
- Ensure that factories follow the established naming conventions

---

# Singleton Pattern

Priority: low

Scope: Global state management

## Rule

SHOULD AVOID the Singleton pattern. Prefer dependency injection for managing single instances.

## Rationale

Singletons introduce global state, make testing difficult, and hide dependencies.

## Exceptions

When the object truly represents a global resource (e.g., loggers, system registries)

## Verification

- Check that singletons are not used for convenience
- Verify that dependency injection is used instead when possible
- Ensure that singletons are thread-safe if used

---

# Strategy Pattern

Priority: medium

Scope: Algorithms and behaviors

## Rule

SHOULD use the Strategy pattern when multiple algorithms or behaviors can be interchanged at runtime.

## Rationale

Strategy pattern makes it easy to add new algorithms without modifying existing code.

## Exceptions

When the number of strategies is small and unlikely to grow

## Verification

- Check that strategies are defined as interfaces
- Verify that strategies can be swapped without modifying context
- Ensure that strategies are stateless or manage their own state

---


# Observer Pattern

Priority: medium

Scope: Event handling and notifications

## Rule

SHOULD use the Observer pattern when one-to-many dependency needs to be maintained.

## Rationale

Observer pattern decouples subjects from observers and allows for dynamic subscription.

## Exceptions

When NeoForge's event system can be used instead

## Verification

- Check that observers subscribe to subjects
- Verify that subjects notify observers of state changes
- Ensure that observers can unsubscribe when no longer needed

---

# Decorator Pattern

Priority: medium

Scope: Adding responsibilities dynamically

## Rule

SHOULD use the Decorator pattern when responsibilities need to be added to objects dynamically.

## Rationale

Decorator pattern provides a flexible alternative to subclassing for extending functionality.

## Exceptions

When the number of decorators is small and inheritance is simpler

## Verification

- Check that decorators implement the same interface as the decorated object
- Verify that decorators wrap the object and add behavior
- Ensure that decorators can be composed

---

# Command Pattern

Priority: medium

Scope: Encapsulating actions

## Rule

SHOULD use the Command pattern when actions need to be encapsulated as objects.

## Rationale

Command pattern allows for queuing, logging, undo operations, and parameterization of actions.

## Exceptions

When the action is simple and doesn't need to be encapsulated

## Verification

- Check that commands implement a common interface
- Verify that commands encapsulate all information needed to execute
- Ensure that commands can be executed, undone, or queued

---


# Adapter Pattern

Priority: medium

Scope: Interface compatibility

## Rule

SHOULD use the Adapter pattern when incompatible interfaces need to work together.

## Rationale

Adapter pattern allows classes with incompatible interfaces to collaborate without modifying their source code.

## Exceptions

When the interface can be modified directly

## Verification

- Check that adapters implement the target interface
- Verify that adapters wrap the adaptee
- Ensure that adapters translate between interfaces

---

# Facade Pattern

Priority: medium

Scope: Simplifying complex subsystems

## Rule

SHOULD use the Facade pattern when a complex subsystem needs a simplified interface.

## Rationale

Facade pattern reduces complexity and provides a single entry point to a complex subsystem.

## Exceptions

When the subsystem is already simple

## Verification

- Check that facades provide a simplified interface
- Verify that facades delegate to the subsystem
- Ensure that facades don't add unnecessary abstraction
