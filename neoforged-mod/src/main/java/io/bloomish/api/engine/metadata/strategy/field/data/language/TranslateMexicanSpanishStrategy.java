package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.language.provider.MexicanSpanishProvider;
import io.bloomish.api.engine.initialization.initializer.StrategyPoolInitializer;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateMexicanSpanish;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class TranslateMexicanSpanishStrategy extends TranslationStrategy<TranslateMexicanSpanish> {
    public TranslateMexicanSpanishStrategy() {
        super(MexicanSpanishProvider.class);
    }

    @Override
    public Class<TranslateMexicanSpanish> getAnnotationClass() {
        return TranslateMexicanSpanish.class;
    }
}
