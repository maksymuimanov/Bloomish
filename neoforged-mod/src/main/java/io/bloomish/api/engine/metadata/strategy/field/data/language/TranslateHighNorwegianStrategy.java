package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.language.provider.HighNorwegianProvider;
import io.bloomish.api.engine.initialization.initializer.StrategyPoolInitializer;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateHighNorwegian;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class TranslateHighNorwegianStrategy extends TranslationStrategy<TranslateHighNorwegian> {
    public TranslateHighNorwegianStrategy() {
        super(HighNorwegianProvider.class);
    }

    @Override
    public Class<TranslateHighNorwegian> getAnnotationClass() {
        return TranslateHighNorwegian.class;
    }
}
