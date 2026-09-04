# Remove Dead Code

## Purpose

Remove unused code, commented-out code, and dead code from the codebase.

## Prerequisites

- Review `.ai/rules/general.md` (No Dead Code rule)
- Identify dead code through IDE inspections or analysis
- Ensure the code is truly unused

## Steps

1. **Identify dead code**
   - Use IDE inspections to find unused code
   - Search for commented-out code
   - Find unused imports
   - Identify unused methods and fields

2. **Verify code is dead**
   - Search for usages of the code
   - Check if the code is called dynamically
   - Verify the code is not part of a public API
   - Ensure the code is not used in generated resources

3. **Remove dead code**
   - Remove unused imports
   - Delete commented-out code blocks
   - Remove unused methods
   - Remove unused fields
   - Remove unused classes

4. **Verify the removal**
   - Ensure the code compiles
   - Run all tests
   - Check for any remaining references
   - Verify no functionality is lost

## Verification

- Dead code is removed
- Code compiles successfully
- Tests pass
- No unused imports remain
- No commented-out code remains
- No unused methods or fields remain
- No functionality is lost
