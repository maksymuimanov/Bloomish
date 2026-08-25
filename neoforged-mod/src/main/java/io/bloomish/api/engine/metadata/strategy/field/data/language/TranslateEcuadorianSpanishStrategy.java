package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.client.language.provider.EcuadorianSpanishProvider;
import io.bloomish.api.engine.initialization.initializer.StrategyInitializer;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateEcuadorianSpanish;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyInitializer.DEFAULT_FIELD_DATA)
public class TranslateEcuadorianSpanishStrategy extends TranslationStrategy<TranslateEcuadorianSpanish> {
    public TranslateEcuadorianSpanishStrategy() {
        super(EcuadorianSpanishProvider.class);
    }

    @Override
    public Class<TranslateEcuadorianSpanish> getAnnotationClass() {
        return TranslateEcuadorianSpanish.class;
    }
}
