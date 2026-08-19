package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.language.provider.RussianProvider;
import io.bloomish.api.engine.initialization.initializer.StrategyInitializer;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateRussian;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyInitializer.DEFAULT_FIELD_DATA)
public class TranslateRussianStrategy extends TranslationStrategy<TranslateRussian> {
    public TranslateRussianStrategy() {
        super(RussianProvider.class);
    }

    @Override
    public Class<TranslateRussian> getAnnotationClass() {
        return TranslateRussian.class;
    }
}
