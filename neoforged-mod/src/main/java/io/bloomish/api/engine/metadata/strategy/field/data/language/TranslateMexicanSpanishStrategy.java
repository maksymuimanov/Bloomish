package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.client.language.provider.MexicanSpanishProvider;
import io.bloomish.api.engine.initialization.initializer.StrategyInitializer;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateMexicanSpanish;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyInitializer.DEFAULT_FIELD_DATA)
public class TranslateMexicanSpanishStrategy extends TranslationStrategy<TranslateMexicanSpanish> {
    public TranslateMexicanSpanishStrategy() {
        super(MexicanSpanishProvider.class);
    }

    @Override
    public Class<TranslateMexicanSpanish> getAnnotationClass() {
        return TranslateMexicanSpanish.class;
    }
}
