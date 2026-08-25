package io.bloomish.api.engine.event.data.server.biome.modifier;

import io.bloomish.api.engine.event.data.preparer.tag.BiomeTagDynamicPreparer;
import io.bloomish.api.engine.event.data.server.biome.GenerationDescriptionContainer;
import io.bloomish.api.engine.event.data.server.biome.dto.Grass;
import io.bloomish.api.util.MapUtils;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

import java.util.Map;

public class GrassBiomeModifierDefinition implements BiomeModifierDefinition<Grass.BiomeModifier> {
    @Override
    public HolderSet.Named<Biome> getBiomes(HolderGetter<Biome> biomes, ResourceKey<ConfiguredFeature<?, ?>> configuredFeatureKey, Grass.BiomeModifier data) {
        TagKey<Biome> biomeTagKey = BiomeTagDynamicPreparer.BIOME_TAGS.get(data.biomeTag());
        return biomes.getOrThrow(biomeTagKey);
    }

    @Override
    public GenerationStep.Decoration getGenerationDecoration(ResourceKey<ConfiguredFeature<?, ?>> configuredFeatureKey, Grass.BiomeModifier data) {
        return GenerationStep.Decoration.VEGETAL_DECORATION;
    }

    @Override
    public Map<ResourceKey<ConfiguredFeature<?, ?>>, Grass.BiomeModifier> getDataSource() {
        return MapUtils.createMap(GenerationDescriptionContainer.GRASSES, Grass::biomeModifier);
    }
}
