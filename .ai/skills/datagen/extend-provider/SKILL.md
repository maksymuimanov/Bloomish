# Extend Provider

## Purpose

Extend an existing data generation provider to add new functionality or support additional cases.

## Prerequisites

- Understand the existing provider implementation
- Review `.ai/rules/datagen.md` and `.ai/rules/dry.md`
- Identify what needs to be added

## Steps

1. **Analyze the existing provider**
   - Understand the current implementation
   - Identify the extension point
   - Check if the provider can be extended without breaking existing functionality
   - Review the provider's usage

2. **Design the extension**
   - Determine if methods can be overridden
   - Identify if new methods need to be added
   - Check if the extension affects existing data generation
   - Plan for backward compatibility

3. **Implement the extension**
   - Override methods if appropriate
   - Add new methods for new functionality
   - Follow the existing code style
   - Ensure the extension integrates cleanly

4. **Update data generation**
   - Ensure the extended provider covers all cases
   - Verify existing data generation still works
   - Test new functionality
   - Check for data consistency

5. **Test the extension**
   - Run data generation
   - Verify existing data is unchanged
   - Verify new data is generated correctly
   - Check for edge cases

## Verification

- Extension follows existing patterns
- Existing functionality is preserved
- New functionality works correctly
- Data generation completes without errors
- Generated data is correct
- Code follows datagen rules
