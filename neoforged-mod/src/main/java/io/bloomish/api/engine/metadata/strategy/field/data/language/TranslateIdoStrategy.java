package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.language.provider.IdoProvider;
import io.bloomish.api.engine.initialization.initializer.StrategyPoolInitializer;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateIdo;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class TranslateIdoStrategy extends TranslationStrategy<TranslateIdo> {
    public TranslateIdoStrategy() {
        super(IdoProvider.class);
    }

    @Override
    public Class<TranslateIdo> getAnnotationClass() {
        return TranslateIdo.class;
    }
}
