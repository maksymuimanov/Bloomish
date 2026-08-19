package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.language.provider.ArmenianProvider;
import io.bloomish.api.engine.initialization.initializer.StrategyPoolInitializer;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateArmenian;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class TranslateArmenianStrategy extends TranslationStrategy<TranslateArmenian> {
    public TranslateArmenianStrategy() {
        super(ArmenianProvider.class);
    }

    @Override
    public Class<TranslateArmenian> getAnnotationClass() {
        return TranslateArmenian.class;
    }
}
