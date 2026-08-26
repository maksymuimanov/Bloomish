package io.bloomish.api.engine.metadata.strategy.field.data.biome;

import io.bloomish.api.data.server.biome.GenerationDescriptionContainer;
import io.bloomish.api.data.server.biome.configuration.ConfiguredFeatureDefinition;
import io.bloomish.api.data.server.biome.modifier.BiomeModifierDefinition;
import io.bloomish.api.data.server.biome.placement.PlacedFeatureDefinition;
import io.bloomish.api.engine.initialization.initializer.StrategyInitializer;
import io.bloomish.api.engine.metadata.annotation.data.biome.GenerateWorldFeature;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;
import io.bloomish.api.engine.metadata.pool.ProcessorScope;
import io.bloomish.api.engine.metadata.processor.DataEventHandlerAnnotationProcessorAdapter;
import io.bloomish.api.engine.metadata.strategy.field.FieldAnnotationStrategy;
import io.bloomish.api.util.ReflectionUtils;

import java.lang.reflect.Field;

@Strategy(StrategyInitializer.DEFAULT_FIELD_DATA)
public class GenerateWorldFeatureStrategy implements FieldAnnotationStrategy<GenerateWorldFeature> {
    @Override
    public void execute(Field field, Object object, GenerateWorldFeature annotation) throws Exception {
        ConfiguredFeatureDefinition<?, ?> configuredFeatureDefinition = ReflectionUtils.createObject(annotation.configuration());
        PlacedFeatureDefinition<?> placedFeatureDefinition = ReflectionUtils.createObject(annotation.placement());
        BiomeModifierDefinition<?> biomeModifierDefinition = ReflectionUtils.createObject(annotation.biomeModifier());
        GenerationDescriptionContainer.CUSTOM_CONFIGURED_FEATURES.add(configuredFeatureDefinition);
        GenerationDescriptionContainer.CUSTOM_PLACED_FEATURES.add(placedFeatureDefinition);
        GenerationDescriptionContainer.CUSTOM_BIOME_MODIFIERS.add(biomeModifierDefinition);
    }

    @Override
    public Class<GenerateWorldFeature> getAnnotationClass() {
        return GenerateWorldFeature.class;
    }

    @Override
    public ProcessorScope getProcessorScope() {
        return new ProcessorScope(DataEventHandlerAnnotationProcessorAdapter.NAME);
    }
}
