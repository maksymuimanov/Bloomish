# Evolve API

## Purpose

Modify or extend existing public API while maintaining backward compatibility.

## Prerequisites

- Understand the existing API and its usage
- Review `.ai/rules/api-design.md` and `.ai/rules/compatibility.md`
- Check if the API is used in the example mod

## Steps

1. **Analyze current API usage**
   - Search for all usages of the API in the codebase
   - Identify breaking changes that would affect users
   - Determine if backward compatibility can be maintained

2. **Design the evolution**
   - Prefer adding new methods over changing existing ones
   - Use default methods in interfaces to add functionality without breaking implementations
   - Consider deprecation for methods that will be removed

3. **Implement the changes**
   - Add new methods/interfaces
   - Deprecate old methods using `@Deprecated` annotation
   - Maintain old method implementations if possible
   - Update internal implementation

4. **Handle breaking changes** (if unavoidable)
   - Document the breaking change clearly
   - Provide migration path for users
   - Update all internal usages
   - Update example mod

5. **Test the evolution**
   - Verify old code still works (if backward compatible)
   - Test new functionality
   - Ensure deprecation warnings are appropriate

## Verification

- Backward compatibility is maintained where possible
- Deprecated methods are properly annotated
- All internal usages are updated
- Example mod compiles and works
- Changes follow API design rules
