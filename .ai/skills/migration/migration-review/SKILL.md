# Migration Review

## Purpose

Review a completed migration to ensure it was done correctly and completely.

## Prerequisites

- Migration has been completed
- Review `.ai/rules/compatibility.md` and relevant technology-specific rules

## Steps

1. **Review build configuration**
   - Verify all version numbers are correct
   - Check dependency versions are appropriate
   - Ensure no legacy dependencies remain
   - Verify plugin configuration is correct

2. **Review API changes**
   - Verify all deprecated APIs are replaced
   - Check for any remaining old API usage
   - Verify new APIs are used correctly
   - Ensure no compatibility workarounds remain if not needed

3. **Review data generation**
   - Verify data generation works correctly
   - Check generated data format is correct
   - Ensure all providers are registered
   - Verify data consistency

4. **Review event handling**
   - Verify events are registered correctly
   - Check event handlers use correct event types
   - Ensure event ordering is correct
   - Verify no duplicate event registrations

5. **Review networking**
   - Verify networking is set up correctly
   - Check packet registration
   - Ensure version handling is correct
   - Verify thread safety

6. **Review client-side segregation**
   - Verify client-only code is properly segregated
   - Check annotations are correct
   - Ensure no client-only code in common paths

7. **Test thoroughly**
   - Test mod loading
   - Test all major features
   - Test edge cases
   - Verify performance is acceptable

## Verification

- All old APIs are replaced
- No deprecated code remains (unless necessary)
- All features work correctly
- Data generation works
- Code follows all relevant rules
- Tests pass
- Performance is acceptable
