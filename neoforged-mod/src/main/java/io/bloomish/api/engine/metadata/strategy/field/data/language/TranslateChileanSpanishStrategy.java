package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.client.language.provider.ChileanSpanishProvider;
import io.bloomish.api.engine.initialization.initializer.StrategyInitializer;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateChileanSpanish;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyInitializer.DEFAULT_FIELD_DATA)
public class TranslateChileanSpanishStrategy extends TranslationStrategy<TranslateChileanSpanish> {
    public TranslateChileanSpanishStrategy() {
        super(ChileanSpanishProvider.class);
    }

    @Override
    public Class<TranslateChileanSpanish> getAnnotationClass() {
        return TranslateChileanSpanish.class;
    }
}
