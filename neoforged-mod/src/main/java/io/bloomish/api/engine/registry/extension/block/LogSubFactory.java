package io.bloomish.api.engine.registry.extension.block;

import io.bloomish.api.common.block.LogBlock;
import io.bloomish.api.common.block.StrippableLogBlock;
import io.bloomish.api.engine.context.InjectionPool;
import io.bloomish.api.engine.registry.factory.BlockFactory;
import io.bloomish.api.engine.registry.factory.BlockPropertiesFactory;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredBlock;

import java.util.function.Supplier;

public interface LogSubFactory {
    default DeferredBlock<StrippableLogBlock> createLog(String name, Supplier<? extends Block> strippedBlock) {
        return this.createLog(name, BlockPropertiesFactory.wood(), strippedBlock);
    }

    default DeferredBlock<StrippableLogBlock> createLog(String name, BlockBehaviour.Properties properties, Supplier<? extends Block> strippedBlock) {
        return this.createLog(name, properties, new Item.Properties(), strippedBlock);
    }

    default DeferredBlock<StrippableLogBlock> createLog(String name, BlockBehaviour.Properties properties, Item.Properties itemProperties, Supplier<? extends Block> strippedBlock) {
        final BlockFactory blockFactory = InjectionPool.getFromInstance(BlockFactory.class);
        return blockFactory.create(name, properties, props -> new StrippableLogBlock(strippedBlock.get(), props), itemProperties);
    }

    default DeferredBlock<LogBlock> createLog(String name) {
        return this.createLog(name, BlockPropertiesFactory.wood());
    }

    default DeferredBlock<LogBlock> createLog(String name, BlockBehaviour.Properties properties) {
        return this.createLog(name, properties, new Item.Properties());
    }

    default DeferredBlock<LogBlock> createLog(String name, BlockBehaviour.Properties properties, Item.Properties itemProperties) {
        final BlockFactory blockFactory = InjectionPool.getFromInstance(BlockFactory.class);
        return blockFactory.create(name, properties, LogBlock::new, itemProperties);
    }
}
