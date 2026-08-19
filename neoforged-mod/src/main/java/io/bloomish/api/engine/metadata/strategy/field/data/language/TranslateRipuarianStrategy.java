package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.language.provider.RipuarianProvider;
import io.bloomish.api.engine.initialization.initializer.StrategyInitializer;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateRipuarian;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyInitializer.DEFAULT_FIELD_DATA)
public class TranslateRipuarianStrategy extends TranslationStrategy<TranslateRipuarian> {
    public TranslateRipuarianStrategy() {
        super(RipuarianProvider.class);
    }

    @Override
    public Class<TranslateRipuarian> getAnnotationClass() {
        return TranslateRipuarian.class;
    }
}
