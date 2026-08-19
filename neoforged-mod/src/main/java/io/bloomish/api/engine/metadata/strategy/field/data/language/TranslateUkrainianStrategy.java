package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.language.provider.UkrainianProvider;
import io.bloomish.api.engine.initialization.initializer.StrategyInitializer;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateUkrainian;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;

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
