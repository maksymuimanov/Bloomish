package io.bloomish.api.engine.metadata.annotation.data.biome;

import io.bloomish.api.engine.event.data.biome.configuration.ConfiguredFeatureDefinition;
import io.bloomish.api.engine.event.data.biome.modifier.BiomeModifierDefinition;
import io.bloomish.api.engine.event.data.biome.placement.PlacedFeatureDefinition;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface GenerateWorldFeature {
    Class<? extends ConfiguredFeatureDefinition<?, ?>> configuration();
    Class<? extends PlacedFeatureDefinition<?>> placement();
    Class<? extends BiomeModifierDefinition<?>> biomeModifier();
}
