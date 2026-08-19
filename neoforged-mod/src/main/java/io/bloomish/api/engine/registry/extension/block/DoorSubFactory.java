package io.bloomish.api.engine.registry.extension.block;

import io.bloomish.api.engine.context.DefaultObjectRegistry;
import io.bloomish.api.engine.registry.factory.BlockFactory;
import io.bloomish.api.engine.registry.factory.BlockPropertiesFactory;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.neoforged.neoforge.registries.DeferredBlock;

public interface DoorSubFactory {
    default DeferredBlock<DoorBlock> createDoor(String name, BlockSetType setType) {
        return createDoor(name, BlockPropertiesFactory.door(), setType);
    }

    default DeferredBlock<DoorBlock> createDoor(String name, BlockBehaviour.Properties properties, BlockSetType setType) {
        return this.createDoor(name, properties, new Item.Properties(), setType);
    }

    default DeferredBlock<DoorBlock> createDoor(String name, BlockBehaviour.Properties properties, Item.Properties itemProperties, BlockSetType setType) {
        final BlockFactory blockFactory = DefaultObjectRegistry.getFromInstance(BlockFactory.class);
        return blockFactory.create(name, properties, props -> new DoorBlock(setType, props), itemProperties);
    }
}
