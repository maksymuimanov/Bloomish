package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.language.provider.PolishProvider;
import io.bloomish.api.engine.initialization.initializer.StrategyPoolInitializer;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslatePolish;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class TranslatePolishStrategy extends TranslationStrategy<TranslatePolish> {
    public TranslatePolishStrategy() {
        super(PolishProvider.class);
    }

    @Override
    public Class<TranslatePolish> getAnnotationClass() {
        return TranslatePolish.class;
    }
}
