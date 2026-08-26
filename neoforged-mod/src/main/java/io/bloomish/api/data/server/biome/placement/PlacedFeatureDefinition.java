package io.bloomish.api.data.server.biome.placement;

import io.bloomish.api.data.server.biome.GenerationDefinition;
import io.bloomish.api.data.server.biome.PlacedFeaturesContainer;
import io.bloomish.api.util.DeprecatedResourceUtils;
import io.bloomish.api.util.WorldGenerationUtils;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;

import java.util.List;

public interface PlacedFeatureDefinition<D> extends GenerationDefinition<PlacedFeature, D> {
    @Override
    default void generate(BootstrapContext<PlacedFeature> context) {
        this.getDataSource().forEach((configuredFeatureKey, data) -> {
            String id = DeprecatedResourceUtils.getResourceId(configuredFeatureKey);
            String placedFeatureName = this.getName(configuredFeatureKey, data);
            ResourceKey<PlacedFeature> placedFeature = DeprecatedResourceUtils.createKey(Registries.PLACED_FEATURE, placedFeatureName);
            PlacedFeaturesContainer.PLACED_FEATURES.put(id, placedFeature);
            HolderGetter<ConfiguredFeature<?, ?>> featureHolderGetter = context.lookup(Registries.CONFIGURED_FEATURE);
            WorldGenerationUtils.registerFeature(context, placedFeature, featureHolderGetter.getOrThrow(configuredFeatureKey), getPlacementModifiers(configuredFeatureKey, data));
        });
    }

    default String getName(ResourceKey<ConfiguredFeature<?, ?>> configuredFeatureKey, D data) {
        return DeprecatedResourceUtils.getResourceId(configuredFeatureKey) + "_placed";
    }

    List<PlacementModifier> getPlacementModifiers(ResourceKey<ConfiguredFeature<?, ?>> configuredFeatureKey, D data);
}
