package io.bloomish.api.engine.event.data.loot.strategy;

import io.bloomish.api.engine.event.data.loot.ApiBlockLootTableProvider;
import io.bloomish.api.engine.event.data.loot.LootProviderStrategy;
import io.bloomish.api.engine.event.data.loot.spec.BlockLootTableSpec;
import net.minecraft.world.level.block.Block;

public class PottedContentLootProviderStrategy implements LootProviderStrategy<BlockLootTableSpec> {
    @Override
    public void generateLoot(BlockLootTableSpec spec, ApiBlockLootTableProvider provider) {
        Block block = spec.getBlock();
        provider.dropPottedContents(block);
    }
}
