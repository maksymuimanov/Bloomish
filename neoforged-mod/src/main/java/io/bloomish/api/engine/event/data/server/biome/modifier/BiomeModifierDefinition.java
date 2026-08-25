package io.bloomish.api.engine.event.data.server.biome.modifier;

import io.bloomish.api.engine.event.data.server.biome.BiomeModifiersContainer;
import io.bloomish.api.engine.event.data.server.biome.GenerationDefinition;
import io.bloomish.api.engine.event.data.server.biome.PlacedFeaturesContainer;
import io.bloomish.api.util.ResourceUtils;
import io.bloomish.api.util.WorldGenerationUtils;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public interface BiomeModifierDefinition<D> extends GenerationDefinition<BiomeModifier, D> {
    @Override
    default void generate(BootstrapContext<BiomeModifier> context) {
        this.getDataSource().forEach((configuredFeatureKey, data) -> {
            String configuredFeatureId = ResourceUtils.getResourceId(configuredFeatureKey);
            String registryName = ResourceUtils.mapId(configuredFeatureId, (path) -> "add_" + path);
            ResourceKey<BiomeModifier> biomeModifierKey = ResourceUtils.createKey(NeoForgeRegistries.Keys.BIOME_MODIFIERS, registryName);
            BiomeModifiersContainer.BIOME_MODIFIERS.put(configuredFeatureId, biomeModifierKey);
            WorldGenerationUtils.registerFeature(context, biomeModifierKey,
                    getBiomes(context.lookup(Registries.BIOME), configuredFeatureKey, data),
                    getPlacedFeature(context.lookup(Registries.PLACED_FEATURE), configuredFeatureKey, data),
                    getGenerationDecoration(configuredFeatureKey, data));
        });
    }

    HolderSet.Named<Biome> getBiomes(HolderGetter<Biome> biomes, ResourceKey<ConfiguredFeature<?, ?>> configuredFeatureKey, D data);

    default HolderSet.Direct<PlacedFeature> getPlacedFeature(HolderGetter<PlacedFeature> placedFeatures, ResourceKey<ConfiguredFeature<?, ?>> configuredFeatureKey, D data) {
        ResourceKey<PlacedFeature> placedFeatureResourceKey = PlacedFeaturesContainer.PLACED_FEATURES.get(ResourceUtils.getResourceId(configuredFeatureKey));
        return HolderSet.direct(placedFeatures.getOrThrow(placedFeatureResourceKey));
    }

    GenerationStep.Decoration getGenerationDecoration(ResourceKey<ConfiguredFeature<?, ?>> configuredFeatureKey, D data);
}
