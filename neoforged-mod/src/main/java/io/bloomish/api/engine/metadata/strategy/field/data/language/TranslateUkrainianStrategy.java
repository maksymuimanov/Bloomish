package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.client.language.provider.UkrainianProvider;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateUkrainian;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;
import io.bloomish.api.initialization.initializer.StrategyInitializer;

@Strategy(StrategyInitializer.DEFAULT_FIELD_DATA)
public class TranslateUkrainianStrategy extends TranslationStrategy<TranslateUkrainian> {
    public TranslateUkrainianStrategy() {
        super(UkrainianProvider.class);
    }

    @Override
    public Class<TranslateUkrainian> getAnnotationClass() {
        return TranslateUkrainian.class;
    }
}
