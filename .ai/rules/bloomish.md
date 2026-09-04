# Reuse Existing Mechanisms

Priority: critical

Scope: All code

## Rule

MUST reuse existing Bloomish mechanisms before creating new ones. Do not duplicate functionality.

## Rationale

Reusing existing mechanisms maintains consistency, reduces code duplication, and leverages tested implementations.

## Exceptions

When the existing mechanism cannot be adapted to the new requirement without breaking existing functionality.

## Verification

- Search for existing implementations of the same concept
- Check if existing utilities or abstractions can be extended
- Verify that a new mechanism is truly necessary

---

# Follow Established Patterns

Priority: critical

Scope: All code

## Rule

MUST follow established patterns in the Bloomish codebase. Do not introduce new patterns when existing ones solve the problem.

## Rationale

Consistent patterns make the codebase predictable and easier to navigate for developers.

## Exceptions

When the existing pattern is fundamentally flawed and needs replacement

## Verification

- Inspect existing implementations of similar functionality
- Identify the architectural pattern being used
- Ensure the new code follows the same pattern

---

# API Consistency

Priority: high

Scope: Public API

## Rule

MUST maintain consistency across similar APIs in the Bloomish framework.

## Rationale

Consistent APIs reduce learning curve and make the framework intuitive to use.

## Exceptions

None

## Verification

- Check that similar classes have similar method signatures
- Verify that naming conventions are consistent across the API
- Ensure that behavioral patterns are consistent

---

# Extensibility Points

Priority: high

Scope: API design

## Rule

MUST provide clear extensibility points for users who need to customize behavior.

## Rationale

A framework should be extensible without requiring users to modify core code.

## Exceptions

When the functionality is intentionally fixed and not meant to be customized

## Verification

- Check that extension points are documented (if documentation is requested)
- Verify that abstract classes or interfaces are used where appropriate
- Ensure that users can override or extend behavior without modifying framework code

---

# No Internal Exposure

Priority: high

Scope: API design

## Rule

MUST NOT expose internal implementation details in the public API.

## Rationale

Internal details should be hidden to allow them to change without breaking users.

## Exceptions

When the internal detail is intentionally part of the API contract

## Verification

- Check that implementation classes are not in public API packages
- Verify that internal methods are not public
- Ensure that package-private access is used for internal details
