package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.language.provider.EcuadorianSpanishProvider;
import io.bloomish.api.engine.initialization.initializer.StrategyPoolInitializer;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateEcuadorianSpanish;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class TranslateEcuadorianSpanishStrategy extends TranslationStrategy<TranslateEcuadorianSpanish> {
    public TranslateEcuadorianSpanishStrategy() {
        super(EcuadorianSpanishProvider.class);
    }

    @Override
    public Class<TranslateEcuadorianSpanish> getAnnotationClass() {
        return TranslateEcuadorianSpanish.class;
    }
}
