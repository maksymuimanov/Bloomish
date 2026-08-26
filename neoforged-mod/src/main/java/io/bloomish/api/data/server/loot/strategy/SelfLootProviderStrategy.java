package io.bloomish.api.data.server.loot.strategy;

import io.bloomish.api.data.server.loot.ApiBlockLootTableProvider;
import io.bloomish.api.data.server.loot.LootProviderStrategy;
import io.bloomish.api.data.server.loot.spec.BlockLootTableSpec;
import net.minecraft.world.level.block.Block;

public class SelfLootProviderStrategy implements LootProviderStrategy<BlockLootTableSpec> {
    @Override
    public void generateLoot(BlockLootTableSpec spec, ApiBlockLootTableProvider provider) {
        Block block = spec.getBlock();
        provider.dropSelf(block);
    }
}
