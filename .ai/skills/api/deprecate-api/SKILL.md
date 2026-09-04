# Deprecate API

## Purpose

Mark API elements as deprecated for future removal while providing migration guidance.

## Prerequisites

- Understand the API being deprecated
- Have a replacement API ready or planned
- Review `.ai/rules/compatibility.md`

## Steps

1. **Identify deprecation scope**
   - Determine which classes, methods, or fields to deprecate
   - Check for usages in the codebase
   - Identify the replacement API

2. **Add deprecation annotations**
   - Add `@Deprecated` annotation to deprecated elements
   - Add Javadoc with `@deprecated` tag explaining why and what to use instead (if documentation is requested)
   - Set deprecation for removal if appropriate: `@Deprecated(since = "X.Y.Z", forRemoval = true)`

3. **Update internal usage**
   - Replace all internal usages with the replacement API
   - Update example mod to use replacement API
   - Verify no internal code depends on deprecated API

4. **Document the migration** (if documentation is requested)
   - Provide clear migration guide
   - Show before/after examples
   - Explain the reason for deprecation

5. **Plan for removal**
   - Determine the version when the deprecated API will be removed
   - Track deprecated APIs in a central location if needed

## Verification

- All deprecated elements are properly annotated
- Internal code does not use deprecated APIs
- Example mod does not use deprecated APIs
- Migration path is clear (if documented)
- Deprecation follows semantic versioning principles
