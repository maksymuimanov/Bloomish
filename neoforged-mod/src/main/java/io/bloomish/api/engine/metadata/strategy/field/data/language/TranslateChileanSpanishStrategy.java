package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.language.provider.ChileanSpanishProvider;
import io.bloomish.api.engine.initialization.initializer.StrategyPoolInitializer;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateChileanSpanish;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class TranslateChileanSpanishStrategy extends TranslationStrategy<TranslateChileanSpanish> {
    public TranslateChileanSpanishStrategy() {
        super(ChileanSpanishProvider.class);
    }

    @Override
    public Class<TranslateChileanSpanish> getAnnotationClass() {
        return TranslateChileanSpanish.class;
    }
}
