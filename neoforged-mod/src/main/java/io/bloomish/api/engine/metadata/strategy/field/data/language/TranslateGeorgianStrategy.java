package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.language.provider.GeorgianProvider;
import io.bloomish.api.engine.initialization.initializer.StrategyPoolInitializer;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateGeorgian;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class TranslateGeorgianStrategy extends TranslationStrategy<TranslateGeorgian> {
    public TranslateGeorgianStrategy() {
        super(GeorgianProvider.class);
    }

    @Override
    public Class<TranslateGeorgian> getAnnotationClass() {
        return TranslateGeorgian.class;
    }
}
