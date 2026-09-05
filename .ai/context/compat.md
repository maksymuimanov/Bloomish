# Context: Compatibility and Dependency Flow

## Purpose

Provides a fluent API for handling optional mod dependencies and conditional execution based on mod availability.

## Scope

Applies to `io.bloomish.api.compat` package.

## Overview

The compatibility API allows mods to gracefully handle optional dependencies by providing conditional execution flows. When a dependency mod is not present, callbacks are skipped without errors. The API supports both synchronous and asynchronous execution patterns.

## Structure

**Core Interfaces:**

- **DependencyFlowBuilder<B>**: Fluent builder interface for dependency flows
  - `onEvent(EventHandler)` - Add event-based callback
  - `onDependency(DependencyFunction)` - Add dependency callback
  - `next(String, String...)` - Chain to next dependency group
  - `next(B)` - Chain to another builder
  - `build()` - Execute the flow

- **DependencyFunction**: Functional interface for dependency callbacks
  - Single method: `execute()`
  - Used for conditional execution when dependencies are present

**Base Implementation:**

- **AbstractDependencyFlowBuilder<B>**: Base class with common dependency checking logic
  - Checks mod availability via `ModList.get().isLoaded()`
  - Skips callbacks for missing dependencies (logs warning)
  - Maintains queue of callbacks for execution
  - Provides protected access to dependency IDs and callbacks

**Concrete Implementations:**

- **SimpleDependencyFlowBuilder**: Synchronous dependency flow
  - Factory: `ofDependencies(String, String...)`
  - Executes callbacks sequentially on build
  - Simple, blocking execution

- **AsyncDependencyFlowBuilder**: Asynchronous dependency flow
  - Factory: `ofDependencies(String, String...)` with default ForkJoinPool
  - Constructor accepts custom ExecutorService
  - `buildAsync()` returns CompletableFuture<Void>
  - `nextAsync()` for async chaining
  - Wraps exceptions in DependencyFlowException

**Exception Handling:**

- **DependencyFlowException**: RuntimeException wrapper for async execution errors
  - Wraps original cause
  - Thrown when async callback execution fails

## Conventions

- Dependency IDs are mod IDs as registered in NeoForge
- Missing dependencies are logged as warnings, not errors
- Callbacks are only added if ALL dependencies in a group are present
- Multiple dependency IDs can be specified for AND logic (all must be present)
- Chaining with `next()` creates OR logic between groups

## Dependencies

- `net.neoforged.fml.ModList` - For checking mod load status
- `io.bloomish.api.engine.event.EventHandler` - For event-based callbacks
- `io.bloomish.api.util.CollectionUtils` - For list creation helpers
- `java.util.concurrent` - For async execution (AsyncDependencyFlowBuilder)

## Constraints

- Dependency checking happens at callback registration time, not execution time
- Once a callback is registered, it will execute (unless dependency was missing at registration)
- Async execution uses provided ExecutorService or ForkJoinPool.commonPool() by default
- Exceptions in async execution are wrapped and logged

## Examples

**Simple synchronous flow:**
```java
SimpleDependencyFlowBuilder.ofDependencies("othermod")
    .onDependency(() -> {
        // This only runs if "othermod" is loaded
        OtherModApi.doSomething();
    })
    .build();
```

**Multiple dependencies (AND logic):**
```java
SimpleDependencyFlowBuilder.ofDependencies("mod1", "mod2")
    .onDependency(() -> {
        // Only runs if BOTH mod1 and mod2 are loaded
        Integration.setup();
    })
    .build();
```

**Chained dependencies (OR logic):**
```java
SimpleDependencyFlowBuilder.ofDependencies("mod1")
    .onDependency(() -> Mod1Integration.setup())
    .next("mod2")
    .onDependency(() -> Mod2Integration.setup())
    .build();
```

**Event-based callback:**
```java
SimpleDependencyFlowBuilder.ofDependencies("othermod")
    .onEvent(() -> {
        // EventHandler.handle() will be called
        eventBus.register(new OtherModEventHandler());
    })
    .build();
```

**Asynchronous flow:**
```java
AsyncDependencyFlowBuilder.ofDependencies("othermod")
    .onDependency(() -> OtherModApi.heavyOperation())
    .buildAsync()
    .thenRun(() -> LOGGER.info("Done"));
```

**Async chaining:**
```java
AsyncDependencyFlowBuilder.ofDependencies("mod1")
    .onDependency(() -> Mod1Integration.setup())
    .nextAsync("mod2")
    .thenAccept(builder -> builder
        .onDependency(() -> Mod2Integration.setup())
        .build());
```

**Custom thread pool:**
```java
ExecutorService pool = Executors.newFixedThreadPool(4);
AsyncDependencyFlowBuilder builder = new AsyncDependencyFlowBuilder(
    pool, 
    List.of("othermod")
);
builder.onDependency(() -> OtherModApi.operation()).build();
```

## Source of Truth

- `io.bloomish.api.compat.DependencyFlowBuilder` - Builder interface
- `io.bloomish.api.compat.AbstractDependencyFlowBuilder` - Base implementation
- `io.bloomish.api.compat.SimpleDependencyFlowBuilder` - Synchronous implementation
- `io.bloomish.api.compat.AsyncDependencyFlowBuilder` - Asynchronous implementation
