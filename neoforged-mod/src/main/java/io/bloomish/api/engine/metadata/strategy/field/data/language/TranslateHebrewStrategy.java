package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.language.provider.HebrewProvider;
import io.bloomish.api.engine.initialization.initializer.StrategyInitializer;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateHebrew;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyInitializer.DEFAULT_FIELD_DATA)
public class TranslateHebrewStrategy extends TranslationStrategy<TranslateHebrew> {
    public TranslateHebrewStrategy() {
        super(HebrewProvider.class);
    }

    @Override
    public Class<TranslateHebrew> getAnnotationClass() {
        return TranslateHebrew.class;
    }
}
