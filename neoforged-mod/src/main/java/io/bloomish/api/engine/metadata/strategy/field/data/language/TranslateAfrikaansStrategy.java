package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.language.provider.AfrikaansProvider;
import io.bloomish.api.engine.initialization.initializer.StrategyInitializer;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateAfrikaans;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyInitializer.DEFAULT_FIELD_DATA)
public class TranslateAfrikaansStrategy extends TranslationStrategy<TranslateAfrikaans> {
    public TranslateAfrikaansStrategy() {
        super(AfrikaansProvider.class);
    }

    @Override
    public Class<TranslateAfrikaans> getAnnotationClass() {
        return TranslateAfrikaans.class;
    }
}
