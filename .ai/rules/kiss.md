# Keep It Simple, Stupid (KISS)

Priority: high

Scope: All code

## Rule

MUST keep code simple. Avoid unnecessary complexity. Simple code is easier to understand, maintain, and debug.

## Rationale

Complex code is harder to understand, more prone to bugs, and more difficult to maintain. Simplicity should be the primary goal.

## Exceptions

When the problem domain is inherently complex and cannot be simplified

## Verification

- Check that solutions are as simple as possible
- Verify that over-engineering is avoided
- Ensure that code is straightforward and easy to follow

---

# Avoid Premature Abstraction

Priority: high

Scope: All code

## Rule

MUST NOT create abstractions before they are needed. Abstractions should solve actual problems, not hypothetical ones.

## Rationale

Premature abstractions add complexity without providing benefit. They often turn out to be wrong when the real requirements emerge.

## Exceptions

When the abstraction is clearly needed based on current requirements

## Verification

- Check that abstractions solve actual problems
- Verify that abstractions are not created "just in case"
- Ensure that the simplest solution is used for the current problem

---

# Short Methods

Priority: high

Scope: All methods

## Rule

MUST keep methods short. Methods should do one thing and do it well.

## Rationale

Short methods are easier to understand, test, and reuse. Long methods are hard to read and often do multiple things.

## Exceptions

When a method is naturally long but still cohesive (rare)

## Verification

- Check that methods are typically under 20-30 lines
- Verify that methods have a single responsibility
- Ensure that complex logic is extracted into smaller methods

---


# Avoid Nested Control Flow

Priority: medium

Scope: All code

## Rule

SHOULD avoid deep nesting. Deep nesting makes code hard to read and understand.

## Rationale

Shallow nesting improves readability and reduces cognitive load.

## Exceptions

When the logic naturally requires nesting

## Verification

- Check that nesting depth is typically 3 or fewer levels
- Verify that guard clauses are used to reduce nesting
- Ensure that complex conditions are extracted into methods

---


# Avoid Clever Code

Priority: high

Scope: All code

## Rule

MUST avoid clever tricks and obscure language features. Code should be straightforward and obvious.

## Rationale

Clever code is hard to understand and maintain. What seems clever to one person is confusing to others.

## Exceptions

When the clever solution is significantly simpler and more efficient

## Verification

- Check that code is straightforward and obvious
- Verify that obscure language features are avoided
- Ensure that code doesn't require deep language knowledge to understand

---

# Prefer Standard Solutions

Priority: medium

Scope: All code

## Rule

SHOULD prefer standard, well-known solutions over custom, novel approaches.

## Rationale

Standard solutions are well-understood, tested, and easier for others to comprehend.

## Exceptions

When standard solutions don't fit the specific problem

## Verification

- Check that standard libraries and patterns are used
- Verify that custom solutions are justified
- Ensure that novel approaches are truly necessary
