package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.client.language.provider.HighNorwegianProvider;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateHighNorwegian;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;
import io.bloomish.api.initialization.initializer.StrategyInitializer;

@Strategy(StrategyInitializer.DEFAULT_FIELD_DATA)
public class TranslateHighNorwegianStrategy extends TranslationStrategy<TranslateHighNorwegian> {
    public TranslateHighNorwegianStrategy() {
        super(HighNorwegianProvider.class);
    }

    @Override
    public Class<TranslateHighNorwegian> getAnnotationClass() {
        return TranslateHighNorwegian.class;
    }
}
