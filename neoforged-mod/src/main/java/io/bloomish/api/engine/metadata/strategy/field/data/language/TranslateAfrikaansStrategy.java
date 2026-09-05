package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.client.language.provider.AfrikaansProvider;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateAfrikaans;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;
import io.bloomish.api.initialization.initializer.StrategyInitializer;

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
