package io.bloomish.api.engine.event.data.server.loot.strategy;

import io.bloomish.api.engine.event.data.server.loot.ApiBlockLootTableProvider;
import io.bloomish.api.engine.event.data.server.loot.LootProviderStrategy;
import io.bloomish.api.engine.event.data.server.loot.spec.OtherItemBlockLootTableSpec;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class MushroomBlockLootProviderStrategy implements LootProviderStrategy<OtherItemBlockLootTableSpec> {
    @Override
    public void generateLoot(OtherItemBlockLootTableSpec spec, ApiBlockLootTableProvider provider) {
        Block block = spec.getBlock();
        Item item = spec.getOtherItem();
        provider.add(block, provider.createMushroomBlockDrop(block, item));
    }
}
