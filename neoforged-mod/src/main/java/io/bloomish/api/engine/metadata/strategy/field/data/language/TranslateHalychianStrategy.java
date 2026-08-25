package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.client.language.provider.HalychianProvider;
import io.bloomish.api.engine.initialization.initializer.StrategyInitializer;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateHalychian;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyInitializer.DEFAULT_FIELD_DATA)
public class TranslateHalychianStrategy extends TranslationStrategy<TranslateHalychian> {
    public TranslateHalychianStrategy() {
        super(HalychianProvider.class);
    }

    @Override
    public Class<TranslateHalychian> getAnnotationClass() {
        return TranslateHalychian.class;
    }
}
