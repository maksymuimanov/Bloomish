package io.bloomish.api.engine.event.data.server.loot;

import io.bloomish.api.engine.event.data.server.loot.spec.BlockLootTableSpec;

public interface LootProviderStrategy<T extends BlockLootTableSpec> {
    void generateLoot(T spec, ApiBlockLootTableProvider provider);
}
