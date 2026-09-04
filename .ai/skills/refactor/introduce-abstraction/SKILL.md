# Introduce Abstraction

## Purpose

Extract common functionality into abstractions (interfaces, abstract classes) to reduce duplication and improve flexibility.

## Prerequisites

- Identify duplicate or similar code patterns
- Review `.ai/rules/architecture.md` and `.ai/rules/dry.md`
- Understand the common behavior to abstract

## Steps

1. **Identify the abstraction**
   - Find classes or methods with similar behavior
   - Identify the common operations
   - Determine the variations that need to be supported
   - Check if an existing abstraction can be used

2. **Design the abstraction**
   - Create an interface or abstract class
   - Define the common methods
   - Use generics if appropriate
   - Follow interface segregation principle

3. **Implement the abstraction**
   - Create the interface/abstract class in the appropriate package
   - Update existing classes to implement the abstraction
   - Extract common implementation to abstract base class if needed
   - Ensure all implementations follow the contract

4. **Update usages**
   - Update code to use the abstraction instead of concrete types
   - Update dependency injection if applicable
   - Ensure type safety is maintained

5. **Test the abstraction**
   - Verify all implementations work correctly
   - Test the abstraction with new implementations
   - Ensure the abstraction is flexible enough

## Verification

- Abstraction follows existing patterns
- All implementations are correct
- Code duplication is reduced
- Abstraction is not over-engineered
- Code compiles successfully
- Tests pass
