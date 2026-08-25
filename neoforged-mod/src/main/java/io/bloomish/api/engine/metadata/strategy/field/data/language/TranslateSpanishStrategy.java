package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.client.language.provider.SpanishProvider;
import io.bloomish.api.engine.initialization.initializer.StrategyInitializer;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateSpanish;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyInitializer.DEFAULT_FIELD_DATA)
public class TranslateSpanishStrategy extends TranslationStrategy<TranslateSpanish> {
    public TranslateSpanishStrategy() {
        super(SpanishProvider.class);
    }

    @Override
    public Class<TranslateSpanish> getAnnotationClass() {
        return TranslateSpanish.class;
    }
}
