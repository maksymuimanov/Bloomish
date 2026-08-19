package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.language.provider.EastFranconianProvider;
import io.bloomish.api.engine.initialization.initializer.StrategyInitializer;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateEastFranconian;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyInitializer.DEFAULT_FIELD_DATA)
public class TranslateEastFranconianStrategy extends TranslationStrategy<TranslateEastFranconian> {
    public TranslateEastFranconianStrategy() {
        super(EastFranconianProvider.class);
    }

    @Override
    public Class<TranslateEastFranconian> getAnnotationClass() {
        return TranslateEastFranconian.class;
    }
}
