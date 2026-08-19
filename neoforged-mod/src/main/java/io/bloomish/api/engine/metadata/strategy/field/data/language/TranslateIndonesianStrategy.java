package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.language.provider.IndonesianProvider;
import io.bloomish.api.engine.initialization.initializer.StrategyInitializer;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateIndonesian;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyInitializer.DEFAULT_FIELD_DATA)
public class TranslateIndonesianStrategy extends TranslationStrategy<TranslateIndonesian> {
    public TranslateIndonesianStrategy() {
        super(IndonesianProvider.class);
    }

    @Override
    public Class<TranslateIndonesian> getAnnotationClass() {
        return TranslateIndonesian.class;
    }
}
