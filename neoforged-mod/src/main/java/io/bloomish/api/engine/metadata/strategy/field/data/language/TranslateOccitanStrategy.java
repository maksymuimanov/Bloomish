package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.language.provider.OccitanProvider;
import io.bloomish.api.engine.initialization.initializer.StrategyPoolInitializer;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateOccitan;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class TranslateOccitanStrategy extends TranslationStrategy<TranslateOccitan> {
    public TranslateOccitanStrategy() {
        super(OccitanProvider.class);
    }

    @Override
    public Class<TranslateOccitan> getAnnotationClass() {
        return TranslateOccitan.class;
    }
}
