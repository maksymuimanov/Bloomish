package io.bloomish.api.engine.event.data.biome.dto;

import io.bloomish.api.engine.metadata.constant.OrePlacementShape;
import io.bloomish.api.engine.metadata.constant.OreRarity;

public record Ore(String id, Configuration configuration, Placement placement, BiomeModifier biomeModifier) {
    public record Configuration(String blockId, String[] replaceableBlocksIds, String replaceableBlocksTag, int size, float discardChanceOnAirExposure) {
    }

    public record Placement(OreRarity rarity, int count, OrePlacementShape shape, int from, int to) {
    }

    public record BiomeModifier(String biomeTag) {
    }
}
