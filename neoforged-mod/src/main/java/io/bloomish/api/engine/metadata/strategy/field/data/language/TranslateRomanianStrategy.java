package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.language.provider.RomanianProvider;
import io.bloomish.api.engine.initialization.initializer.StrategyInitializer;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateRomanian;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyInitializer.DEFAULT_FIELD_DATA)
public class TranslateRomanianStrategy extends TranslationStrategy<TranslateRomanian> {
    public TranslateRomanianStrategy() {
        super(RomanianProvider.class);
    }

    @Override
    public Class<TranslateRomanian> getAnnotationClass() {
        return TranslateRomanian.class;
    }
}
