package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.client.language.provider.RomanianProvider;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateRomanian;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;
import io.bloomish.api.initialization.initializer.StrategyInitializer;

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
