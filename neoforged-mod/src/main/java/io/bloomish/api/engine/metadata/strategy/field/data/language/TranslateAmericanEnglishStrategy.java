package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.client.language.provider.AmericanEnglishProvider;
import io.bloomish.api.engine.initialization.initializer.StrategyInitializer;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateAmericanEnglish;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyInitializer.DEFAULT_FIELD_DATA)
public class TranslateAmericanEnglishStrategy extends TranslationStrategy<TranslateAmericanEnglish> {
    public TranslateAmericanEnglishStrategy() {
        super(AmericanEnglishProvider.class);
    }

    @Override
    public Class<TranslateAmericanEnglish> getAnnotationClass() {
        return TranslateAmericanEnglish.class;
    }
}
