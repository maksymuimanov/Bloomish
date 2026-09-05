package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.client.language.provider.ArmenianProvider;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateArmenian;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;
import io.bloomish.api.initialization.initializer.StrategyInitializer;

@Strategy(StrategyInitializer.DEFAULT_FIELD_DATA)
public class TranslateArmenianStrategy extends TranslationStrategy<TranslateArmenian> {
    public TranslateArmenianStrategy() {
        super(ArmenianProvider.class);
    }

    @Override
    public Class<TranslateArmenian> getAnnotationClass() {
        return TranslateArmenian.class;
    }
}
