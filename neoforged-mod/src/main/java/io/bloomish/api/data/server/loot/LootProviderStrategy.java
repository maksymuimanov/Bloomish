package io.bloomish.api.data.server.loot;

import io.bloomish.api.data.server.loot.spec.BlockLootTableSpec;

public interface LootProviderStrategy<T extends BlockLootTableSpec> {
    void generateLoot(T spec, ApiBlockLootTableProvider provider);
}
