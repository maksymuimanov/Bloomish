# Extract Component

## Purpose

Extract a cohesive set of functionality into a separate component/class to improve modularity and reduce complexity.

## Prerequisites

- Identify a cohesive unit of functionality that can be extracted
- Review `.ai/rules/architecture.md` and `.ai/rules/kiss.md`
- Understand dependencies of the code to extract

## Steps

1. **Identify the component**
   - Find code that has a single, well-defined responsibility
   - Identify the data and operations that belong together
   - Determine the component's interface
   - Check if similar components already exist

2. **Design the component**
   - Define the component's responsibility
   - Design the public interface
   - Determine dependencies
   - Plan for extensibility if needed

3. **Extract the component**
   - Create the new class in the appropriate package
   - Move relevant code to the new component
   - Update the original code to use the new component
   - Ensure proper encapsulation

4. **Handle dependencies**
   - Inject dependencies rather than creating them
   - Use appropriate dependency injection mechanisms
   - Ensure the component can be tested independently

5. **Test the component**
   - Test the component in isolation
   - Verify the original code still works
   - Ensure no functionality is lost

## Verification

- Component has a single responsibility
- Component is properly encapsulated
- Dependencies are injected appropriately
- Original code is simplified
- Code compiles successfully
- Tests pass
