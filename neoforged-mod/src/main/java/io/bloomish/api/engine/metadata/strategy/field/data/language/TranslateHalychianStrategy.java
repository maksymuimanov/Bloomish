package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.language.provider.HalychianProvider;
import io.bloomish.api.engine.initialization.initializer.StrategyPoolInitializer;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateHalychian;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class TranslateHalychianStrategy extends TranslationStrategy<TranslateHalychian> {
    public TranslateHalychianStrategy() {
        super(HalychianProvider.class);
    }

    @Override
    public Class<TranslateHalychian> getAnnotationClass() {
        return TranslateHalychian.class;
    }
}
