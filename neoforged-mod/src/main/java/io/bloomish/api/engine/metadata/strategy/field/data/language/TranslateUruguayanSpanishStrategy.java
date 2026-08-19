package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.language.provider.UruguayanSpanishProvider;
import io.bloomish.api.engine.initialization.initializer.StrategyPoolInitializer;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateUruguayanSpanish;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class TranslateUruguayanSpanishStrategy extends TranslationStrategy<TranslateUruguayanSpanish> {
    public TranslateUruguayanSpanishStrategy() {
        super(UruguayanSpanishProvider.class);
    }

    @Override
    public Class<TranslateUruguayanSpanish> getAnnotationClass() {
        return TranslateUruguayanSpanish.class;
    }
}
