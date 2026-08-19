package io.bloomish.api.engine.event.data.loot;

import io.bloomish.api.engine.event.data.loot.spec.BlockLootTableSpec;

public interface LootProviderStrategy<T extends BlockLootTableSpec> {
    void generateLoot(T spec, ApiBlockLootTableProvider provider);
}
