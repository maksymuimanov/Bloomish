package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.client.language.provider.ArabicProvider;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateArabic;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;
import io.bloomish.api.initialization.initializer.StrategyInitializer;

@Strategy(StrategyInitializer.DEFAULT_FIELD_DATA)
public class TranslateArabicStrategy extends TranslationStrategy<TranslateArabic> {
    public TranslateArabicStrategy() {
        super(ArabicProvider.class);
    }

    @Override
    public Class<TranslateArabic> getAnnotationClass() {
        return TranslateArabic.class;
    }
}
