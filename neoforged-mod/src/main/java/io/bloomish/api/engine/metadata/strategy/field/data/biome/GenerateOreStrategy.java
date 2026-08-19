package io.bloomish.api.engine.metadata.strategy.field.data.biome;

import io.bloomish.api.engine.event.data.biome.GenerationDescriptionContainer;
import io.bloomish.api.engine.event.data.biome.dto.Ore;
import io.bloomish.api.engine.event.data.preparer.tag.BiomeTagDynamicPreparer;
import io.bloomish.api.engine.event.data.preparer.tag.BlockTagDynamicPreparer;
import io.bloomish.api.engine.initialization.initializer.StrategyInitializer;
import io.bloomish.api.engine.metadata.annotation.data.biome.GenerateOre;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;
import io.bloomish.api.engine.metadata.pool.ProcessorScope;
import io.bloomish.api.engine.metadata.processor.DataEventHandlerAnnotationProcessorAdapter;
import io.bloomish.api.engine.metadata.strategy.field.FieldAnnotationStrategy;
import io.bloomish.api.util.ReflectionUtils;
import io.bloomish.api.util.ResourceUtils;
import io.bloomish.api.util.TagUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

import java.lang.reflect.Field;

@Strategy(StrategyInitializer.DEFAULT_FIELD_DATA)
public class GenerateOreStrategy implements FieldAnnotationStrategy<GenerateOre> {
    @Override
    public void execute(Field field, Object object, GenerateOre annotation) throws Exception {
        ResourceKey<ConfiguredFeature<?, ?>> configuredFeatureKey = ReflectionUtils.getFieldValue(field, object);
        var annotationConfiguration = annotation.configuration();
        var annotationPlacement = annotation.placement();
        var annotationBiomeModifier = annotation.biomeModifier();
        TagUtils.putTagContainer(BlockTagDynamicPreparer.TAG_CONTAINERS, annotationConfiguration.blockTagContainer());
        TagUtils.putTagContainer(BiomeTagDynamicPreparer.TAG_CONTAINERS, annotationBiomeModifier.biomeTagContainer());
        var configuration = new Ore.Configuration(annotationConfiguration.ore(), annotationConfiguration.replaceableBlocks(), annotationConfiguration.replaceableBlocksTag(), annotationConfiguration.size(), annotationConfiguration.discardChanceOnAirExposure());
        var placement = new Ore.Placement(annotationPlacement.rarity(), annotationPlacement.count(), annotationPlacement.shape(), annotationPlacement.from(), annotationPlacement.to());
        var biomeModifier = new Ore.BiomeModifier(annotationBiomeModifier.biomeTag());
        Ore ore = new Ore(ResourceUtils.getResourceId(configuredFeatureKey), configuration, placement, biomeModifier);
        GenerationDescriptionContainer.ORES.put(configuredFeatureKey, ore);
    }

    @Override
    public Class<GenerateOre> getAnnotationClass() {
        return GenerateOre.class;
    }

    @Override
    public ProcessorScope getProcessorScope() {
        return new ProcessorScope(DataEventHandlerAnnotationProcessorAdapter.NAME);
    }
}
