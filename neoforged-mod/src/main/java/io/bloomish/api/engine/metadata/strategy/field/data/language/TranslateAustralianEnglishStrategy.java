package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.language.provider.AustralianEnglishProvider;
import io.bloomish.api.engine.initialization.initializer.StrategyInitializer;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateAustralianEnglish;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyInitializer.DEFAULT_FIELD_DATA)
public class TranslateAustralianEnglishStrategy extends TranslationStrategy<TranslateAustralianEnglish> {
    public TranslateAustralianEnglishStrategy() {
        super(AustralianEnglishProvider.class);
    }

    @Override
    public Class<TranslateAustralianEnglish> getAnnotationClass() {
        return TranslateAustralianEnglish.class;
    }
}
