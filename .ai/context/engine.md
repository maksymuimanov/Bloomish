# Context: Bloomish Engine

## Purpose

Describes the BloomishEngine layered mod initialization system that orchestrates mod setup through a series of processing layers.

## Scope

Applies to `io.bloomish.api.engine` package and all layer implementations.

## Overview

The BloomishEngine is a modular initialization framework for NeoForge mods that uses a layered architecture to process mod setup in a controlled, sequential manner. Each layer handles a specific aspect of mod initialization, from basic setup to final cleanup.

## Structure

**Core Components:**

- **BloomishEngine**: Main entry point with ASCII banner display and default builder configuration
- **EngineBuilder**: Fluent builder API for configuring and assembling layers
- **LayerContainer**: Manages the collection of layers, provides lookup and removal capabilities

**Layer System:**

The engine uses a layered architecture where each layer handles a specific aspect of mod initialization. See `layers.md` for detailed information about individual layers, their responsibilities, and customization options.

## Conventions

- Use `BloomishEngine.run()` for default setup or `BloomishEngine.builder()` for custom configuration
- The engine displays an ASCII banner on startup
- All layer configuration happens through the EngineBuilder fluent API
- LayerContainer is returned after build, allowing layer retrieval

## Dependencies

- NeoForge event bus and ModContainer for mod integration
- ModContext for shared state (managed by InitializationLayer)
- Individual layers have their own dependencies (see layers.md)

## Constraints

- Engine must be run once per mod during initialization
- Builder pattern requires layers to be configured before build() is called

## Examples

**Default engine setup:**
```java
LayerContainer container = BloomishEngine.run(
    MyMod.class, 
    modEventBus, 
    modContainer
);
```

**Custom engine with selective layers:**
```java
LayerContainer container = BloomishEngine.builder()
    .initializationLayer(customizer -> customizer
        .modClass(MyMod.class)
        .externalSource(List.of(eventBus, modContainer)))
    .registryLayer()
    .metadataLayer()
    .eventLayer()
    .build();
```

**Using default builder with modifications:**
```java
LayerContainer container = BloomishEngine.defaultBuilder(modClass, eventBus, modContainer)
    .disableLayer(ConfigLayer.class)
    .build();
```

## Source of Truth

- `io.bloomish.api.engine.BloomishEngine` - Entry point and default configuration
- `io.bloomish.api.engine.EngineBuilder` - Layer configuration API
- Individual layer classes in `io.bloomish.api.engine.*` packages
