package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.client.language.provider.UruguayanSpanishProvider;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateUruguayanSpanish;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;
import io.bloomish.api.initialization.initializer.StrategyInitializer;

@Strategy(StrategyInitializer.DEFAULT_FIELD_DATA)
public class TranslateUruguayanSpanishStrategy extends TranslationStrategy<TranslateUruguayanSpanish> {
    public TranslateUruguayanSpanishStrategy() {
        super(UruguayanSpanishProvider.class);
    }

    @Override
    public Class<TranslateUruguayanSpanish> getAnnotationClass() {
        return TranslateUruguayanSpanish.class;
    }
}
