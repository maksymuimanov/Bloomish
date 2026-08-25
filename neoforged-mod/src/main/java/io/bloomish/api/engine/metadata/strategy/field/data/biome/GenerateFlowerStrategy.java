package io.bloomish.api.engine.metadata.strategy.field.data.biome;

import io.bloomish.api.engine.event.data.preparer.tag.BiomeTagDynamicPreparer;
import io.bloomish.api.engine.event.data.server.biome.GenerationDescriptionContainer;
import io.bloomish.api.engine.event.data.server.biome.dto.Flower;
import io.bloomish.api.engine.initialization.initializer.StrategyInitializer;
import io.bloomish.api.engine.metadata.annotation.data.biome.GenerateFlower;
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
public class GenerateFlowerStrategy implements FieldAnnotationStrategy<GenerateFlower> {
    @Override
    public void execute(Field field, Object object, GenerateFlower annotation) throws Exception {
        ResourceKey<ConfiguredFeature<?, ?>> configuredFeatureKey = ReflectionUtils.getFieldValue(field, object);
        var annotationConfiguration = annotation.configuration();
        var annotationPlacement = annotation.placement();
        var annotationBiomeModifier = annotation.biomeModifier();
        TagUtils.putTagContainer(BiomeTagDynamicPreparer.TAG_CONTAINERS, annotationBiomeModifier.biomeTagContainer());
        var configuration = new Flower.Configuration(annotationConfiguration.flower(), annotationConfiguration.tries(), annotationConfiguration.xzSpread(), annotationConfiguration.ySpread(), annotationConfiguration.noiseSeed(), annotationConfiguration.noiseScale(), annotationConfiguration.noiseThreshold(), annotationConfiguration.noiseHighChance(), annotationConfiguration.firstOctave(), annotationConfiguration.amplitudes(), annotationConfiguration.lowStateFlowers(), annotationConfiguration.highStateFlowers());
        var placement = new Flower.Placement(annotationPlacement.chance(), annotationPlacement.noiseLevel(), annotationPlacement.belowNoise(), annotationPlacement.aboveNoise());
        var biomeModifier = new Flower.BiomeModifier(annotationBiomeModifier.biomeTag());
        Flower flower = new Flower(ResourceUtils.getResourceId(configuredFeatureKey), configuration, placement, biomeModifier);
        GenerationDescriptionContainer.FLOWERS.put(configuredFeatureKey, flower);
    }

    @Override
    public Class<GenerateFlower> getAnnotationClass() {
        return GenerateFlower.class;
    }

    @Override
    public ProcessorScope getProcessorScope() {
        return new ProcessorScope(DataEventHandlerAnnotationProcessorAdapter.NAME);
    }
}
