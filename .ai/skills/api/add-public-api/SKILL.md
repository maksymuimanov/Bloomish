# Add Public API

## Purpose

Add new public API functionality to the Bloomish framework.

## Prerequisites

- Understand the existing API structure in `neoforged-mod/src/main/java/io/bloomish/api/`
- Review existing similar APIs to maintain consistency
- Check `.ai/rules/api-design.md` for API design principles

## Steps

1. **Identify the API location**
   - Determine which package the new API belongs to (e.g., `util`, `data`, `engine`)
   - Check if a similar API already exists that can be extended

2. **Design the API**
   - Follow Effective Java and Clean Code principles from `.ai/rules/api-design.md`
   - Use interfaces for public APIs where appropriate
   - Consider immutability for API classes
   - Use Optional<T> for return values that may be absent
   - Minimize method parameters (3 or fewer when possible)

3. **Implement the API**
   - Create the interface/abstract class in the appropriate package
   - Implement the concrete class (if needed) in an internal package
   - Follow existing naming conventions
   - Add defensive copies for mutable parameters

4. **Register the API**
   - If the API needs registration, use the appropriate engine layer
   - Register in the correct initialization phase
   - Ensure proper dependency ordering

5. **Test the API**
   - Verify the API works correctly
   - Test edge cases
   - Ensure the API can be used from the example mod

6. **Update documentation** (if requested by user)
   - Document the API usage
   - Provide examples

## Verification

- API follows existing patterns in the codebase
- API is in the correct package
- Implementation details are not exposed in public API
- API is consistent with similar APIs
- Code compiles successfully
