package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.client.language.provider.EsperantoProvider;
import io.bloomish.api.engine.initialization.initializer.StrategyInitializer;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateEsperanto;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyInitializer.DEFAULT_FIELD_DATA)
public class TranslateEsperantoStrategy extends TranslationStrategy<TranslateEsperanto> {
    public TranslateEsperantoStrategy() {
        super(EsperantoProvider.class);
    }

    @Override
    public Class<TranslateEsperanto> getAnnotationClass() {
        return TranslateEsperanto.class;
    }
}
