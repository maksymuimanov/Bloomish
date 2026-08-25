package io.bloomish.api.engine.event.data.server.loot.strategy;

import io.bloomish.api.engine.event.data.server.loot.ApiBlockLootTableProvider;
import io.bloomish.api.engine.event.data.server.loot.LootProviderStrategy;
import io.bloomish.api.engine.event.data.server.loot.spec.BlockLootTableSpec;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.level.block.Block;

public class EmptyLootProviderStrategy implements LootProviderStrategy<BlockLootTableSpec> {
    @Override
    public void generateLoot(BlockLootTableSpec spec, ApiBlockLootTableProvider provider) {
        Block block = spec.getBlock();
        provider.add(block, BlockLootSubProvider.noDrop());
    }
}
