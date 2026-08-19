package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.language.provider.AndalusianProvider;
import io.bloomish.api.engine.initialization.initializer.StrategyPoolInitializer;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateAndalusian;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class TranslateAndalusianStrategy extends TranslationStrategy<TranslateAndalusian> {
    public TranslateAndalusianStrategy() {
        super(AndalusianProvider.class);
    }

    @Override
    public Class<TranslateAndalusian> getAnnotationClass() {
        return TranslateAndalusian.class;
    }
}
