package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.client.language.provider.OccitanProvider;
import io.bloomish.api.engine.initialization.initializer.StrategyInitializer;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateOccitan;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyInitializer.DEFAULT_FIELD_DATA)
public class TranslateOccitanStrategy extends TranslationStrategy<TranslateOccitan> {
    public TranslateOccitanStrategy() {
        super(OccitanProvider.class);
    }

    @Override
    public Class<TranslateOccitan> getAnnotationClass() {
        return TranslateOccitan.class;
    }
}
