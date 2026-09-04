# Code Style and Formatting

Priority: high

Scope: All Java files

## Rule

MUST follow consistent code formatting and style throughout the codebase.

## Rationale

Consistent code style improves readability, maintainability, and reduces cognitive load when switching between files.

## Exceptions

None

## Verification

- Check that code follows the project's established formatting conventions
- Verify consistent indentation, spacing, and bracket placement
- Ensure line lengths are reasonable (typically 120-150 characters)

---

# File Organization

Priority: high

Scope: All Java files

## Rule

MUST organize files with clear package structure and logical grouping of related classes.

## Rationale

Well-organized code is easier to navigate, understand, and maintain.

## Exceptions

None

## Verification

- Verify that classes are placed in appropriate packages
- Check that related classes are grouped together
- Ensure package names follow Java conventions (lowercase, reverse domain)

---

# Naming Conventions

Priority: high

Scope: All code elements

## Rule

MUST use descriptive, meaningful names following Java naming conventions.

## Rationale

Clear naming makes code self-documenting and reduces the need for additional comments.

## Exceptions

None

## Verification

- Classes: PascalCase (e.g., BlockStateProvider)
- Methods: camelCase (e.g., registerBlock)
- Constants: UPPER_SNAKE_CASE (e.g., MAX_BLOCKS)
- Variables: camelCase (e.g., blockRegistry)
- Packages: lowercase with dots (e.g., io.bloomish.api)

---

# Minimal Changes

Priority: critical

Scope: All modifications

## Rule

MUST make the smallest change that satisfies the requirement. Do not rewrite unrelated code.

## Rationale

Minimal changes reduce risk, make reviews easier, and prevent introducing unintended side effects.

## Exceptions

When the existing code is fundamentally broken and requires a larger refactor.

## Verification

- Confirm that only the necessary code is modified
- Check that unrelated functionality is not changed
- Verify that the change is scoped to the specific requirement

---

# No Dead Code

Priority: medium

Scope: All code

## Rule

MUST NOT leave commented-out code, unused imports, or dead code in the codebase.

## Rationale

Dead code clutters the codebase, confuses readers, and can hide bugs.

## Exceptions

Temporarily during debugging (must be removed before committing)

## Verification

- Remove unused imports
- Delete commented-out code blocks
- Remove unused methods and fields
- Run IDE inspections to identify dead code

---

# Error Handling

Priority: high

Scope: All code

## Rule

MUST handle errors appropriately based on the context. Never silently ignore exceptions.

## Rationale

Proper error handling prevents bugs from propagating and makes debugging easier.

## Exceptions

None

## Verification

- Check that exceptions are either handled or properly propagated
- Verify that catch blocks are not empty
- Ensure error messages are descriptive
