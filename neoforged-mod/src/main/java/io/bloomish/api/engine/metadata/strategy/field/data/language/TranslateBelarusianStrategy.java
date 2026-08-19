package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.language.provider.BelarusianProvider;
import io.bloomish.api.engine.initialization.initializer.StrategyInitializer;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateBelarusian;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyInitializer.DEFAULT_FIELD_DATA)
public class TranslateBelarusianStrategy extends TranslationStrategy<TranslateBelarusian> {
    public TranslateBelarusianStrategy() {
        super(BelarusianProvider.class);
    }

    @Override
    public Class<TranslateBelarusian> getAnnotationClass() {
        return TranslateBelarusian.class;
    }
}
