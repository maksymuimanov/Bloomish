package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.client.language.provider.NewZealandEnglishProvider;
import io.bloomish.api.engine.initialization.initializer.StrategyInitializer;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateNewZealandEnglish;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyInitializer.DEFAULT_FIELD_DATA)
public class TranslateNewZealandEnglishStrategy extends TranslationStrategy<TranslateNewZealandEnglish> {
    public TranslateNewZealandEnglishStrategy() {
        super(NewZealandEnglishProvider.class);
    }

    @Override
    public Class<TranslateNewZealandEnglish> getAnnotationClass() {
        return TranslateNewZealandEnglish.class;
    }
}
