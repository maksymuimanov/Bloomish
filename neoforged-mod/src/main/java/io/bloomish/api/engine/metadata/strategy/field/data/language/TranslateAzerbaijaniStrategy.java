package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.language.provider.AzerbaijaniProvider;
import io.bloomish.api.engine.initialization.initializer.StrategyInitializer;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateAzerbaijani;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyInitializer.DEFAULT_FIELD_DATA)
public class TranslateAzerbaijaniStrategy extends TranslationStrategy<TranslateAzerbaijani> {
    public TranslateAzerbaijaniStrategy() {
        super(AzerbaijaniProvider.class);
    }

    @Override
    public Class<TranslateAzerbaijani> getAnnotationClass() {
        return TranslateAzerbaijani.class;
    }
}
