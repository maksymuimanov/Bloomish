package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.client.language.provider.CanadianEnglishProvider;
import io.bloomish.api.engine.initialization.initializer.StrategyInitializer;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateCanadianEnglish;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyInitializer.DEFAULT_FIELD_DATA)
public class TranslateCanadianEnglishStrategy extends TranslationStrategy<TranslateCanadianEnglish> {
    public TranslateCanadianEnglishStrategy() {
        super(CanadianEnglishProvider.class);
    }

    @Override
    public Class<TranslateCanadianEnglish> getAnnotationClass() {
        return TranslateCanadianEnglish.class;
    }
}
