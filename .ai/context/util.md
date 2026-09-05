# Context: Utility Classes

## Purpose

Provides a collection of utility methods for common operations in Minecraft mod development, reducing boilerplate code.

## Scope

Applies to `io.bloomish.api.util` package.

## Overview

The util package contains static utility classes that provide helper methods for common operations including string manipulation, collection handling, resource location parsing, registry access, reflection, and Minecraft-specific utilities.

## Structure

**String Utilities (`StringUtils`):**

- Null-safe empty/blank checks: `isEmpty()`, `isNotEmpty()`, `isBlank()`, `isNotBlank()`
- Case checking: `isUpperCase()`, `isLowerCase()`
- Comparison: `isEqualIgnoreCase()`
- Joining: `joinWithUnderscore()`

**Collection Utilities (`CollectionUtils`):**

- Null-safe empty checks: `isEmpty()`, `isNotEmpty()`
- Vararg factory methods:
  - `arrayListOf(T, T...)` - Creates ArrayList
  - `concurrentLinkedQueueOf(T, T...)` - Creates ConcurrentLinkedQueue
  - `hashMapOf(K, V, Entry<K,V>...)` - Creates HashMap

**Map Utilities (`MapUtils`):**

- **@Deprecated** - Marked for removal
- Multi-map operations: `putToSetMap()`, `putToListMap()`
- Map transformation: `createMap()` with key/value mappers

**Resource Location Utilities (`ResourceLocationUtils`):**

- Parsing with default namespace: `parseLocation(String, String)`
- Mod-specific location creation: `createModLocation()`
- Minecraft location creation: `createMinecraftLocation()`
- Path joining: `joinModPath()`, `joinMinecraftPath()`, `joinNamespacedPath()`

**Registry Path Utilities (`RegistryPathUtils`):**

- Extract path/namespace from registry entries:
  - `findBlockPath()`, `findBlockNamespace()`, `findBlockNamespacedPath()`
  - `findItemPath()`, `findItemNamespace()`, `findItemNamespacedPath()`
- Generic methods: `findPath()`, `findNamespace()`, `findNamespacedPath()`

**Tag Utilities (`TagUtils`):**

- Type-safe tag creation for various registries:
  - `createBannerPattern()`, `createBiome()`, `createBlock()`, `createItem()`
  - `createEntityType()`, `createFluid()`, `createEnchantment()`, etc.
- Generic: `createTag(ResourceKey, String)`
- **@Deprecated** methods for tag mapping and reflection

**Block Utilities (`BlockUtils`):**

- Find blocks by path: `findBlock()`, `findMinecraftBlock()`, `findModBlock()`
- Find all blocks by path: `findBlocks()`

**Item Utilities (`ItemUtils`):**

- Find items by path: `findItem()`, `findMinecraftItem()`, `findModItem()`
- Find all items by path: `findItems()`

**Holder Utilities (`HolderUtils`):**

- Unwrap holders to values: `unwrapToArray()`, `unwrapToList()`

**Reflection Utilities (`ReflectionUtils`):**

- Object creation: `createObject()`
- Field access: `getFieldValue()`
- Method invocation: `invokeMethod()`
- Factory detection: `isFactoryPresent()`
- Type loading: `forType()`, `forName()`
- Stream operations on fields: `getStaticFieldTypeStream()`, `getStaticFieldStream()`
- Annotation comparison: `compareByAnnotationOverrideMethodPresence()`
- Mod class discovery: `getApiDependentsClasses()`, `getApiClasses()`

**World Generation Utilities (`WorldGenerationUtils`):**

- Ore placement: `createCommonOrePlacement()`, `createRareOrePlacement()`, `createOrePlacement()`
- Feature registration: `registerFeature()` for ConfiguredFeature, PlacedFeature, BiomeModifier

**Enum Extension Utilities (`EnumExtensionUtils`):**

- Boat type creation: `createBoatType()` with various overloads
- Handles Minecraft's enum extension pattern

**Other Utilities:**

- `MinecraftConstants` - Constants for "minecraft" and "neoforge" namespaces
- `ItemStackUtils` - Null-safe empty check for ItemStack
- `ResourceKeyUtils` - Extract ResourceKey streams from classes
- `EnumExtensionUtils` - Handle Minecraft enum extensions

**Deprecated Utilities:**

- `DeprecatedRegistryUtils` - **@Deprecated** registry access methods
- `DeprecatedResourceUtils` - **@Deprecated(forRemoval=true)** resource location methods

## Conventions

- All utility classes have private constructors (static-only)
- Methods are null-safe where appropriate
- Default namespace for mod-specific operations comes from ModContext
- Deprecated methods are clearly marked and should not be used in new code

## Dependencies

- `io.bloomish.api.engine.context.ModContext` - For current mod ID
- `net.minecraft.core.registries.BuiltInRegistries` - For registry access
- `net.minecraft.resources.ResourceLocation` - For resource location handling
- `net.neoforged.fml.ModList` - For mod discovery (ReflectionUtils)
- Various Minecraft/NeoForge classes for domain-specific operations

## Constraints

- Deprecated utilities will be removed in future versions
- Reflection operations wrap exceptions in RuntimeException
- Registry operations assume valid resource locations
- Some utilities require ModContext to be initialized

## Examples

**String utilities:**
```java
if (StringUtils.isNotEmpty(myString)) {
    if (StringUtils.isUpperCase(myString)) {
        // Process uppercase string
    }
}
```

**Collection utilities:**
```java
List<String> list = CollectionUtils.arrayListOf("first", "second", "third");
Queue<Runnable> queue = CollectionUtils.concurrentLinkedQueueOf(task1, task2);
Map<String, Integer> map = CollectionUtils.hashMapOf("key", 1);
```

**Resource location utilities:**
```java
ResourceLocation loc = ResourceLocationUtils.parseLocation("minecraft:stone");
ResourceLocation modLoc = ResourceLocationUtils.createModLocation("block/my_block");
String path = ResourceLocationUtils.joinModPath("blocks", "stone");
```

**Block/Item utilities:**
```java
Block stone = BlockUtils.findMinecraftBlock("stone");
Block myBlock = BlockUtils.findModBlock("my_block");
Item diamond = ItemUtils.findItem("minecraft:diamond");
```

**Tag utilities:**
```java
TagKey<Block> logsTag = TagUtils.createBlock("minecraft:logs");
TagKey<Item> toolsTag = TagUtils.createItem("minecraft:tools");
```

**Holder utilities:**
```java
List<Item> items = HolderUtils.unwrapToList(itemHolders);
Item[] itemArray = HolderUtils.unwrapToArray(itemHolders);
```

**World generation utilities:**
```java
List<PlacementModifier> placement = WorldGenerationUtils.createCommonOrePlacement(
    10, 
    HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.absolute(32))
);
```

**Reflection utilities:**
```java
MyObject obj = ReflectionUtils.createObject(MyObject.class);
String value = ReflectionUtils.getFieldValue(MyClass.class, "fieldName", instance);
MyObject result = ReflectionUtils.invokeMethod(MyClass.class, "methodName", instance);
```

## Source of Truth

- Individual utility classes in `io.bloomish.api.util` package
- Prefer non-deprecated utilities over deprecated ones
- Check individual class documentation for specific behavior
