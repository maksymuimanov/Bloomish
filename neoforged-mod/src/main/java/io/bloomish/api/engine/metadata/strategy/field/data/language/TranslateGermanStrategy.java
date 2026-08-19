package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.language.provider.GermanProvider;
import io.bloomish.api.engine.initialization.initializer.StrategyInitializer;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateGerman;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyInitializer.DEFAULT_FIELD_DATA)
public class TranslateGermanStrategy extends TranslationStrategy<TranslateGerman> {
    public TranslateGermanStrategy() {
        super(GermanProvider.class);
    }

    @Override
    public Class<TranslateGerman> getAnnotationClass() {
        return TranslateGerman.class;
    }
}
