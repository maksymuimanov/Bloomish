package io.bloomish.api.engine.event.data.server.loot.strategy;

import io.bloomish.api.engine.event.data.server.loot.ApiBlockLootTableProvider;
import io.bloomish.api.engine.event.data.server.loot.LootProviderStrategy;
import io.bloomish.api.engine.event.data.server.loot.spec.LeavesBlockLootTableSpec;
import net.minecraft.world.level.block.Block;

import java.util.List;

public class LeavesLootProviderStrategy implements LootProviderStrategy<LeavesBlockLootTableSpec> {
    @Override
    public void generateLoot(LeavesBlockLootTableSpec spec, ApiBlockLootTableProvider provider) {
        Block block = spec.getBlock();
        Block saplingBlock = spec.getSaplingBlock();
        List<Float> specChances = spec.getChances();
        float[] chances = new float[specChances.size()];
        for (int i = 0; i < chances.length; i++) {
            float chance = specChances.get(i);
            chances[i] = chance;
        }
        provider.add(block, provider.createLeavesDrops(block, saplingBlock, chances));
    }
}
