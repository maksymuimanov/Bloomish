package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.language.provider.AmericanEnglishProvider;
import io.bloomish.api.engine.initialization.initializer.StrategyPoolInitializer;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateAmericanEnglish;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class TranslateAmericanEnglishStrategy extends TranslationStrategy<TranslateAmericanEnglish> {
    public TranslateAmericanEnglishStrategy() {
        super(AmericanEnglishProvider.class);
    }

    @Override
    public Class<TranslateAmericanEnglish> getAnnotationClass() {
        return TranslateAmericanEnglish.class;
    }
}
