package io.bloomish.api.engine.metadata.strategy.field.data.biome;

import io.bloomish.api.engine.event.data.biome.GenerationDescriptionContainer;
import io.bloomish.api.engine.event.data.biome.dto.Grass;
import io.bloomish.api.engine.event.data.preparer.tag.BiomeTagDynamicPreparer;
import io.bloomish.api.engine.initialization.initializer.StrategyPoolInitializer;
import io.bloomish.api.engine.metadata.annotation.data.biome.GenerateGrass;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;
import io.bloomish.api.engine.metadata.pool.ProcessorScope;
import io.bloomish.api.engine.metadata.processor.DataEventHandlerAnnotationProcessorAdapter;
import io.bloomish.api.engine.metadata.strategy.field.FieldAnnotationStrategy;
import io.bloomish.api.core.util.ReflectionUtils;
import io.bloomish.api.core.util.ResourceUtils;
import io.bloomish.api.core.util.TagUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

import java.lang.reflect.Field;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class GenerateGrassStrategy implements FieldAnnotationStrategy<GenerateGrass> {
    @Override
    public void execute(Field field, Object object, GenerateGrass annotation) throws Exception {
        ResourceKey<ConfiguredFeature<?, ?>> configuredFeatureKey = ReflectionUtils.getFieldValue(field, object);
        var annotationConfiguration = annotation.configuration();
        var annotationPlacement = annotation.placement();
        var annotationBiomeModifier = annotation.biomeModifier();
        TagUtils.putTagContainer(BiomeTagDynamicPreparer.TAG_CONTAINERS, annotationBiomeModifier.biomeTagContainer());
        var configuration = new Grass.Configuration(annotationConfiguration.grass(), annotationConfiguration.tries());
        var placement = new Grass.Placement(annotationPlacement.count());
        var biomeModifier = new Grass.BiomeModifier(annotationBiomeModifier.biomeTag());
        Grass grass = new Grass(ResourceUtils.getResourceId(configuredFeatureKey), configuration, placement, biomeModifier);
        GenerationDescriptionContainer.GRASSES.put(configuredFeatureKey, grass);
    }

    @Override
    public Class<GenerateGrass> getAnnotationClass() {
        return GenerateGrass.class;
    }

    @Override
    public ProcessorScope getProcessorScope() {
        return new ProcessorScope(DataEventHandlerAnnotationProcessorAdapter.NAME);
    }
}
