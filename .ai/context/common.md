# Context: Common Game Objects

## Purpose

Provides commonly-used game object implementations that mods frequently need, reducing boilerplate code.

## Scope

Applies to `io.bloomish.api.common` package and its subpackages.

## Overview

The common package contains ready-to-use implementations of frequently needed Minecraft game objects, including blocks, loot table modifiers, and particles. These implementations follow vanilla/NeoForge conventions and can be extended or used directly.

## Structure

**Block Implementations (`io.bloomish.api.common.block`):**

- **LogBlock**: Extends `RotatedPillarBlock` with default flammability properties
  - Flammable: returns true
  - Flammability: 5 (standard log value)
  - Fire spread speed: 5 (standard log value)
  
- **StrippableLogBlock**: Extends LogBlock with axe stripping functionality
  - Requires a stripped result block in constructor
  - Preserves axis state when stripped
  - Uses `ItemAbilities.AXE_STRIP` for tool interaction

**Loot Table Modifiers (`io.bloomish.api.common.loot`):**

- **AddItemModifier**: Global loot modifier that adds an item to loot drops
  - Configured via JSON with item field
  - Supports loot conditions
  - Adds item to existing loot (doesn't replace)
  
- **AddSuspiciousSandItemModifier**: Specialized modifier for suspicious sand/gravel
  - 50% chance to replace all loot with the specified item
  - Otherwise leaves loot unchanged
  - Used for archaeology brush rewards

**Particle Implementations (`io.bloomish.api.common.particle`):**

- **SimpleParticle**: Abstract base class for texture-based particles
  - Extends `TextureSheetParticle`
  - Automatically handles sprite animation from age
  - Includes nested `Provider` class for particle registration
  - Provider manages SpriteSet for sprite-based rendering

## Conventions

- All implementations follow vanilla/NeoForge naming and behavior patterns
- Block implementations use standard Minecraft property values (e.g., flammability of 5 for logs)
- Loot modifiers use memoized codecs for performance
- Particle implementations use the provider pattern for registration

## Dependencies

- `net.minecraft.world.level.block` - Block base classes
- `net.neoforged.neoforge.common.loot` - Loot modifier infrastructure
- `net.minecraft.client.particle` - Particle rendering classes
- `com.mojang.serialization` - Codec for loot modifier serialization

## Constraints

- These are base implementations meant to be used as-is or extended
- Custom behavior should be added via subclassing rather than modification
- Loot modifiers require JSON data pack configuration

## Examples

**Using LogBlock:**
```java
public static final Block MY_LOG = new LogBlock(BlockBehaviour.Properties.of()
    .mapColor(MapColor.WOOD)
    .strength(2.0f));
```

**Using StrippableLogBlock:**
```java
public static final Block MY_LOG = new StrippableLogBlock(
    STRIPPED_MY_LOG,  // stripped result
    BlockBehaviour.Properties.of()
        .mapColor(MapColor.WOOD)
        .strength(2.0f)
);
```

**Custom particle extending SimpleParticle:**
```java
public class MyParticle extends SimpleParticle {
    protected MyParticle(ClientLevel level, double x, double y, double z, 
                         double xSpeed, double ySpeed, double zSpeed, SpriteSet spriteSet) {
        super(level, x, y, z, xSpeed, ySpeed, zSpeed, spriteSet);
        this.setSize(0.25f, 0.25f);
        this.lifetime = 20;
    }
    
    public static class Provider extends SimpleParticle.Provider {
        public Provider(SpriteSet spriteSet) {
            super(spriteSet);
        }
        
        @Override
        public Particle createParticle(SimpleParticleType type, ClientLevel level, 
                                      double x, double y, double z, 
                                      double xSpeed, double ySpeed, double zSpeed, SpriteSet spriteSet) {
            return new MyParticle(level, x, y, z, xSpeed, ySpeed, zSpeed, spriteSet);
        }
    }
}
```

## Source of Truth

- Individual implementation classes in `io.bloomish.api.common.*` packages
- NeoForge documentation for block, loot, and particle APIs
