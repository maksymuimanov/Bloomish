# Context: Engine Layers

## Purpose

Describes the layer system architecture used by BloomishEngine for modular mod initialization, including individual layer implementations and customization patterns.

## Scope

Applies to all layer implementations in `io.bloomish.api.engine.*` packages and the layer customization system.

## Overview

The layer system is the core architectural pattern of BloomishEngine. It breaks down mod initialization into discrete, sequential processing stages called layers. Each layer is responsible for a specific aspect of mod setup, and layers can be configured, reordered, disabled, or extended as needed. See `engine.md` for information on the BloomishEngine entry point and builder API.

## Structure

**Core Layer Infrastructure:**

- **EngineLayer**: Simple interface with single `process()` method that all layers must implement
- **LayerCustomizer<L>**: Interface for configuring layers before processing
- **LayerContainer**: Manages the collection and execution order of layers
  - Provides layer lookup by class type
  - Supports layer removal for disabling
  - Maintains unmodifiable view of registered layers

**Layer Customization Pattern:**

Each layer has a corresponding Customizer class that:
- Implements `LayerCustomizer<LayerType>`
- Provides fluent builder methods for configuration
- Has default configurations for common use cases
- Applies configuration via the `customize()` method

**Standard Layers (in execution order):**

1. **InitializationLayer** (`io.bloomish.api.engine.initialization.InitializationLayer`)
   - Customizer: `InitializationLayerCustomizer`
   - Responsibilities:
     - Discovers mod classes via scanners
     - Initializes ModContext with NeoMod information
     - Sets up ObjectRegistry for dependency injection
     - Executes ObjectRegistryInitializers
   - Default scanners: `ClasspathModClassScanner`
   - Default initializers: PackOutput, Gson, BloomishRegister, Factory, EventBus, ModContainer, Injected, Strategy, Processor

2. **RegistryLayer** (`io.bloomish.api.engine.registry.RegistryLayer`)
   - Customizer: `RegistryLayerCustomizer`
   - Responsibilities:
     - Registers FactoryRegistrar instances with event bus
     - Handles deferred registration of game objects
   - Default registrars: `FieldTypeFactoryRegistrar`

3. **MetadataLayer** (`io.bloomish.api.engine.metadata.MetadataLayer`)
   - Customizer: `MetadataLayerCustomizer`
   - Responsibilities:
     - Processes annotation-based metadata
     - Executes annotation processors via ProcessorPool
   - Default directors: ClassAnnotationDirector, FieldAnnotationDirector, MethodAnnotationDirector

4. **ConfigLayer** (`io.bloomish.api.engine.config.ConfigLayer`)
   - Customizer: `ConfigLayerCustomizer`
   - Responsibilities:
     - Processes ConfigAnnotationProcessor
     - Runs ConfigShowcaser instances for config screens

5. **EventLayer** (`io.bloomish.api.engine.event.EventLayer`)
   - No customizer (purely dynamic)
   - Responsibilities:
     - Processes dynamic EventHandler instances from ObjectRegistry
     - No configuration - relies on objects registered in earlier layers

6. **FinalizationLayer** (`io.bloomish.api.engine.finalization.FinalizationLayer`)
   - Customizer: `FinalizationLayerCustomizer`
   - Responsibilities:
     - Runs ObjectPoolCleaner instances
     - Cleans up resources after initialization

## Conventions

- Layers are processed in the order they are added to LayerContainer
- Default layer order is defined in `BloomishEngine.defaultBuilder()`
- Customizers use fluent builder pattern for configuration
- Each layer can have both default and dynamic components (default + ObjectRegistry)
- Layer processing is logged at debug level

## Dependencies

- Layers depend on ModContext for shared state
- ObjectRegistry is the primary mechanism for cross-layer communication
- Earlier layers can register objects that later layers consume
- EventLayer specifically depends on EventHandler registrations from earlier layers

## Constraints

- Layers must be stateless or manage their own state
- Layer processing is sequential and synchronous
- Once a layer is processed, it cannot be reprocessed
- Layers cannot depend on layers that come after them in execution order
- EventLayer has no customizer as it's purely dynamic

## Examples

**Default layer configuration:**
```java
BloomishEngine.defaultBuilder(modClass, eventBus, modContainer)
```

**Customizing a specific layer:**
```java
BloomishEngine.builder()
    .initializationLayer(customizer -> customizer
        .modClass(MyMod.class)
        .externalSource(List.of(eventBus, modContainer))
        .classScanners(List.of(new CustomScanner())))
    .registryLayer()
    .metadataLayer()
    .build();
```

**Disabling a layer:**
```java
BloomishEngine.defaultBuilder(...)
    .disableLayer(ConfigLayer.class)
    .build();
```

**Adding a custom layer:**
```java
BloomishEngine.builder()
    .initializationLayer(...)
    .addLayer(new CustomLayer())
    .registryLayer()
    .build();
```

**Retrieving a layer after build:**
```java
LayerContainer container = BloomishEngine.run(...);
InitializationLayer layer = container.getLayer(InitializationLayer.class);
```

## Source of Truth

- `io.bloomish.api.engine.EngineLayer` - Layer interface
- `io.bloomish.api.engine.LayerCustomizer` - Customizer interface
- `io.bloomish.api.engine.LayerContainer` - Layer management
- Individual layer and customizer implementations in subpackages
