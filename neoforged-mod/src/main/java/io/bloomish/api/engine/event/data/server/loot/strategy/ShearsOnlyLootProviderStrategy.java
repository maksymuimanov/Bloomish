package io.bloomish.api.engine.event.data.server.loot.strategy;

import io.bloomish.api.engine.event.data.server.loot.ApiBlockLootTableProvider;
import io.bloomish.api.engine.event.data.server.loot.LootProviderStrategy;
import io.bloomish.api.engine.event.data.server.loot.spec.BlockLootTableSpec;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.entries.LootItem;

public class ShearsOnlyLootProviderStrategy implements LootProviderStrategy<BlockLootTableSpec> {
    @Override
    public void generateLoot(BlockLootTableSpec spec, ApiBlockLootTableProvider provider) {
        Block block = spec.getBlock();
        provider.add(block, provider.createShearsDispatchTable(block, provider.applyExplosionDecay(block, LootItem.lootTableItem(block))));
    }
}
