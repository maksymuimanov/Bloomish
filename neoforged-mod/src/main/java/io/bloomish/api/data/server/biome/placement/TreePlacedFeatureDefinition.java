package io.bloomish.api.data.server.biome.placement;

import io.bloomish.api.data.server.biome.GenerationDescriptionContainer;
import io.bloomish.api.data.server.biome.dto.Tree;
import io.bloomish.api.util.MapUtils;
import io.bloomish.api.util.RegistryUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;

import java.util.List;
import java.util.Map;

public class TreePlacedFeatureDefinition implements PlacedFeatureDefinition<Tree.Placement> {
    @Override
    public List<PlacementModifier> getPlacementModifiers(ResourceKey<ConfiguredFeature<?, ?>> configuredFeatureKey, Tree.Placement data) {
        return VegetationPlacements.treePlacement(
                PlacementUtils.countExtra(data.baseValue(), data.chance(), data.addedAmount()),
                RegistryUtils.getBlock(data.saplingBlock())
        );
    }

    @Override
    public Map<ResourceKey<ConfiguredFeature<?, ?>>, Tree.Placement> getDataSource() {
        return MapUtils.createMap(GenerationDescriptionContainer.TREES, Tree::placement);
    }
}
