# Fix Bug

## Purpose

Identify and fix a bug in the codebase.

## Prerequisites

- Understand the bug and its symptoms
- Reproduce the bug
- Review relevant rules from `.ai/rules/`
- Identify the root cause

## Steps

1. **Understand the bug**
   - Reproduce the bug consistently
   - Identify the symptoms
   - Determine the scope of the bug
   - Check if it affects users or is internal

2. **Identify the root cause**
   - Trace the code execution
   - Use debugging tools if needed
   - Identify the exact location of the bug
   - Understand why the bug occurs

3. **Design the fix**
   - Determine the minimal change needed
   - Consider edge cases
   - Ensure the fix doesn't introduce new issues
   - Follow the "Minimal Changes" rule from `.ai/rules/general.md`

4. **Implement the fix**
   - Make the smallest change that fixes the bug
   - Do not rewrite unrelated code
   - Add comments only if the fix is non-obvious
   - Follow existing code style

5. **Test the fix**
   - Verify the bug is fixed
   - Test edge cases
   - Ensure no regressions are introduced
   - Run relevant tests

6. **Verify the fix**
   - Check that the fix follows all relevant rules
   - Ensure the fix is minimal
   - Verify no unrelated code was changed

## Verification

- Bug is fixed
- No regressions introduced
- Fix is minimal
- Code follows all relevant rules
- Tests pass
- Edge cases are handled
