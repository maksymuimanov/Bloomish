package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.client.language.provider.EstonianProvider;
import io.bloomish.api.engine.initialization.initializer.StrategyInitializer;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateEstonian;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyInitializer.DEFAULT_FIELD_DATA)
public class TranslateEstonianStrategy extends TranslationStrategy<TranslateEstonian> {
    public TranslateEstonianStrategy() {
        super(EstonianProvider.class);
    }

    @Override
    public Class<TranslateEstonian> getAnnotationClass() {
        return TranslateEstonian.class;
    }
}
