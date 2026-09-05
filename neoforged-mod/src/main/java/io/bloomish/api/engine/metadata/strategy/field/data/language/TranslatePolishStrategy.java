package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.client.language.provider.PolishProvider;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslatePolish;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;
import io.bloomish.api.initialization.initializer.StrategyInitializer;

@Strategy(StrategyInitializer.DEFAULT_FIELD_DATA)
public class TranslatePolishStrategy extends TranslationStrategy<TranslatePolish> {
    public TranslatePolishStrategy() {
        super(PolishProvider.class);
    }

    @Override
    public Class<TranslatePolish> getAnnotationClass() {
        return TranslatePolish.class;
    }
}
