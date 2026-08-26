package io.bloomish.api.data.server.biome.configuration;

import io.bloomish.api.data.server.biome.GenerationDescriptionContainer;
import io.bloomish.api.data.server.biome.dto.Grass;
import io.bloomish.api.util.DeprecatedRegistryUtils;
import io.bloomish.api.util.MapUtils;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

import java.util.Map;

public class GrassConfiguredFeatureDefinition implements ConfiguredFeatureDefinition<Grass.Configuration, RandomPatchConfiguration> {
    @Override
    public Feature<RandomPatchConfiguration> getFeature(ResourceKey<ConfiguredFeature<?, ?>> configuredFeatureKey, Grass.Configuration data) {
        return Feature.RANDOM_PATCH;
    }

    @Override
    public RandomPatchConfiguration getFeatureConfiguration(ResourceKey<ConfiguredFeature<?, ?>> configuredFeatureKey, Grass.Configuration data) {
        return FeatureUtils.simpleRandomPatchConfiguration(
                data.tries(), PlacementUtils.onlyWhenEmpty(
                        Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(
                                BlockStateProvider.simple(DeprecatedRegistryUtils.getBlock(data.blockId()))
                        )
                )
        );
    }

    @Override
    public Map<ResourceKey<ConfiguredFeature<?, ?>>, Grass.Configuration> getDataSource() {
        return MapUtils.createMap(GenerationDescriptionContainer.GRASSES, Grass::configuration);
    }
}
