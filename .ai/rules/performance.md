# Avoid Premature Optimization

Priority: high

Scope: All code

## Rule

MUST NOT optimize code without profiling data showing it is a bottleneck.

## Rationale

Premature optimization complicates code, introduces bugs, and often doesn't improve actual performance.

## Exceptions

When the performance issue is obvious and the fix is simple (e.g., O(n²) algorithm that can be O(n))

## Verification

- Check that optimizations are based on profiling data
- Verify that the optimized code is still readable
- Ensure that the optimization actually improves performance

---

# Object Allocation

Priority: medium

Scope: Performance-critical code

## Rule

SHOULD minimize object allocation in hot paths (e.g., rendering, tick loops).

## Rationale

Excessive allocation causes garbage collection pauses and reduces performance.

## Exceptions

When the objects are small and allocation is not in a hot path

## Verification

- Check that object pools are used for frequently allocated objects
- Verify that temporary objects are not created in loops
- Ensure that allocation is minimized in performance-critical code

---

# Caching

Priority: medium

Scope: Expensive computations

## Rule

SHOULD cache results of expensive computations when the inputs are repeated.

## Rationale

Caching avoids redundant computation and improves performance.

## Exceptions

When the computation is not expensive or the inputs are rarely repeated

## Verification

- Check that expensive computations are cached when appropriate
- Verify that cache invalidation is handled correctly
- Ensure that caching does not cause memory issues

---

# Lazy Initialization

Priority: medium

Scope: Resource-intensive objects

## Rule

SHOULD use lazy initialization for resource-intensive objects that may not be needed.

## Rationale

Lazy initialization avoids unnecessary work and memory usage.

## Exceptions

When the object is always needed immediately

## Verification

- Check that resource-intensive objects are lazily initialized
- Verify that lazy initialization is thread-safe if needed
- Ensure that lazy initialization does not cause complexity

---

# Collection Choice

Priority: medium

Scope: Collection usage

## Rule

MUST choose the appropriate collection type for the use case (ArrayList vs LinkedList, HashSet vs TreeSet, etc.).

## Rationale

Different collections have different performance characteristics. Choosing the wrong one can cause performance issues.

## Exceptions

None

## Verification

- Check that ArrayList is used for random access, LinkedList for frequent modifications
- Verify that HashSet is used for fast lookup, TreeSet for sorted iteration
- Ensure that collection capacity is initialized when size is known

---

# String Concatenation

Priority: medium

Scope: String building

## Rule

MUST use StringBuilder for string concatenation in loops, not the + operator.

## Rationale

String concatenation with + in loops creates many temporary objects and is slow.

## Exceptions

When concatenating a small, fixed number of strings

## Verification

- Check that StringBuilder is used for concatenation in loops
- Verify that + is only used for simple concatenation
- Ensure that StringBuilder is used correctly

---

# I/O Operations

Priority: high

Scope: File and network I/O

## Rule

MUST perform I/O operations asynchronously or off the main thread when possible.

## Rationale

Blocking I/O on the main thread causes lag and freezes.

## Exceptions

When the I/O is fast and synchronous is acceptable

## Verification

- Check that file I/O is not done on the main game thread
- Verify that network operations are asynchronous
- Ensure that I/O errors are handled properly
