package io.bloomish.api.engine.event.data.server.biome;

import io.bloomish.api.core.collection.TemporalQueue;
import io.bloomish.api.engine.event.data.server.biome.configuration.ConfiguredFeatureDefinition;
import io.bloomish.api.engine.event.data.server.biome.dto.Flower;
import io.bloomish.api.engine.event.data.server.biome.dto.Grass;
import io.bloomish.api.engine.event.data.server.biome.dto.Ore;
import io.bloomish.api.engine.event.data.server.biome.dto.Tree;
import io.bloomish.api.engine.event.data.server.biome.modifier.BiomeModifierDefinition;
import io.bloomish.api.engine.event.data.server.biome.placement.PlacedFeatureDefinition;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public final class GenerationDescriptionContainer {
    public static final Map<ResourceKey<ConfiguredFeature<?, ?>>, Ore> ORES = new HashMap<>();
    public static final Map<ResourceKey<ConfiguredFeature<?, ?>>, Tree> TREES = new HashMap<>();
    public static final Map<ResourceKey<ConfiguredFeature<?, ?>>, Flower> FLOWERS = new HashMap<>();
    public static final Map<ResourceKey<ConfiguredFeature<?, ?>>, Grass> GRASSES = new HashMap<>();
    public static final Queue<ConfiguredFeatureDefinition<?, ?>> CUSTOM_CONFIGURED_FEATURES = new TemporalQueue<>();
    public static final Queue<PlacedFeatureDefinition<?>> CUSTOM_PLACED_FEATURES = new TemporalQueue<>();
    public static final Queue<BiomeModifierDefinition<?>> CUSTOM_BIOME_MODIFIERS = new TemporalQueue<>();

    private GenerationDescriptionContainer() {
    }
}
