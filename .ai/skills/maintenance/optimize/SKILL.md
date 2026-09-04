# Optimize

## Purpose

Improve the performance of code without changing its behavior.

## Prerequisites

- Identify a performance bottleneck through profiling
- Review `.ai/rules/performance.md`
- Have baseline performance measurements

## Steps

1. **Profile the code**
   - Use profiling tools to identify bottlenecks
   - Measure current performance
   - Identify hot paths
   - Quantify the performance issue

2. **Analyze the bottleneck**
   - Understand why the code is slow
   - Identify the root cause
   - Determine if optimization is necessary
   - Assess the potential impact of optimization

3. **Design the optimization**
   - Choose the appropriate optimization strategy
   - Consider trade-offs (performance vs readability)
   - Ensure the optimization doesn't change behavior
   - Follow the "Avoid Premature Optimization" rule

4. **Implement the optimization**
   - Make the optimization
   - Keep the code readable
   - Avoid over-engineering
   - Document non-obvious optimizations

5. **Measure the improvement**
   - Profile the optimized code
   - Compare with baseline
   - Verify the improvement is significant
   - Ensure no new performance issues were introduced

6. **Test the optimization**
   - Verify behavior is unchanged
   - Test edge cases
   - Run all tests
   - Check for regressions

## Verification

- Performance is improved
- Behavior is unchanged
- Optimization is based on profiling data
- Code is still readable
- No new performance issues introduced
- Tests pass
