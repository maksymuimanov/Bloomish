package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.client.language.provider.IndonesianProvider;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateIndonesian;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;
import io.bloomish.api.initialization.initializer.StrategyInitializer;

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
