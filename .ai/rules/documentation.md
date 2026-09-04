# No Javadoc by Default

Priority: high

Scope: All code

## Rule

MUST NOT add Javadoc comments unless the user explicitly requests them.

## Rationale

Good code should be self-documenting through clear naming and structure. Javadoc often becomes stale and adds maintenance burden.

## Exceptions

- When user explicitly requests Javadoc
- For public API documentation that will be published
- For complex algorithms that cannot be made self-explanatory

## Verification

- Check that Javadoc comments are not present without explicit user request
- Verify that code is self-documenting through good naming

---

# Self-Documenting Code

Priority: high

Scope: All code

## Rule

MUST write code that is self-documenting through clear naming and structure.

## Rationale

Self-documenting code is always up-to-date and doesn't require separate maintenance.

## Exceptions

None

## Verification

- Check that variable and method names clearly express their purpose
- Verify that complex logic is extracted into well-named methods
- Ensure that the code structure tells the story of what it does

---

# Comments for Why, Not What

Priority: medium

Scope: All code

## Rule

SHOULD add comments only to explain "why" something is done, not "what" is being done.

## Rationale

The code itself shows what is being done. Comments should explain the reasoning behind non-obvious decisions.

## Exceptions

None

## Verification

- Check that comments don't restate the code
- Verify that comments explain the reasoning behind the implementation
- Ensure comments are added for workarounds, hacks, or non-obvious business logic

---

# TODO Comments

Priority: low

Scope: All code

## Rule

SHOULD use TODO comments sparingly and only for temporary, tracked work.

## Rationale

TODO comments can accumulate and become ignored. They should be tracked in the project management system instead.

## Exceptions

None

## Verification

- Check that TODO comments have associated issues
- Verify that TODO comments are not left indefinitely
- Ensure TODO comments are removed when work is completed
