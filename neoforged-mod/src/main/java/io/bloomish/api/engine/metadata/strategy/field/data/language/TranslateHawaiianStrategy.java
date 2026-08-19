package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.language.provider.HawaiianProvider;
import io.bloomish.api.engine.initialization.initializer.StrategyInitializer;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateHawaiian;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyInitializer.DEFAULT_FIELD_DATA)
public class TranslateHawaiianStrategy extends TranslationStrategy<TranslateHawaiian> {
    public TranslateHawaiianStrategy() {
        super(HawaiianProvider.class);
    }

    @Override
    public Class<TranslateHawaiian> getAnnotationClass() {
        return TranslateHawaiian.class;
    }
}
