# Don't Repeat Yourself (DRY)

Priority: high

Scope: All code

## Rule

MUST eliminate duplication. Every piece of knowledge must have a single, unambiguous representation within the system.

## Rationale

Duplication leads to maintenance burden, inconsistencies, and bugs. Changes must be made in multiple places, increasing the risk of errors.

## Exceptions

When duplication is intentional and serves a specific purpose (e.g., documentation, performance optimization)

## Verification

- Check that identical or similar code blocks are extracted into methods
- Verify that constants are used instead of magic numbers/strings
- Ensure that common logic is not repeated across classes

---

# Extract Method

Priority: high

Scope: All methods

## Rule

MUST extract repeated logic into separate methods. If the same logic appears more than once, it should be extracted.

## Rationale

Extracted methods are easier to test, maintain, and reuse. They also improve readability by giving names to operations.

## Exceptions

When the logic is trivial and extracting it would reduce readability

## Verification

- Check that repeated code blocks are extracted into methods
- Verify that extracted methods have descriptive names
- Ensure that methods are short and focused

---

# Shared Utilities

Priority: high

Scope: Common operations

## Rule

MUST create shared utility classes for common operations used across multiple classes.

## Rationale

Shared utilities provide a single source of truth for common operations and reduce duplication.

## Exceptions

When the operation is specific to a single class and unlikely to be reused

## Verification

- Check that common operations are in utility classes
- Verify that utility classes are in appropriate packages
- Ensure that utility methods are static and stateless

---


# Parameterization

Priority: medium

Scope: Similar methods with different parameters

## Rule

SHOULD parameterize methods instead of creating multiple similar methods with slight variations.

## Rationale

Parameterization reduces the number of methods and makes the API more flexible.

## Exceptions

When the variations are too different to be captured by parameters

## Verification

- Check that similar methods are consolidated into parameterized methods
- Verify that parameters cover all necessary variations
- Ensure that parameterized methods are still readable

---

# Configuration Over Code

Priority: medium

Scope: Values that may change

## Rule

SHOULD externalize configuration values instead of hardcoding them in multiple places.

## Rationale

Configuration externalization makes it easy to change values without modifying code.

## Exceptions

When the value is truly constant and will never change

## Verification

- Check that magic numbers and strings are replaced with constants
- Verify that configuration is in appropriate configuration files
- Ensure that configuration is loaded from a single source
