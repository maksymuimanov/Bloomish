package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.language.provider.ArgentianSpanishProvider;
import io.bloomish.api.engine.initialization.initializer.StrategyPoolInitializer;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateArgentianSpanish;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class TranslateArgentianSpanishStrategy extends TranslationStrategy<TranslateArgentianSpanish> {
    public TranslateArgentianSpanishStrategy() {
        super(ArgentianSpanishProvider.class);
    }

    @Override
    public Class<TranslateArgentianSpanish> getAnnotationClass() {
        return TranslateArgentianSpanish.class;
    }
}
