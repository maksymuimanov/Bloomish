package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.language.provider.LowGermanProvider;
import io.bloomish.api.engine.initialization.initializer.StrategyPoolInitializer;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateLowGerman;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class TranslateLowGermanStrategy extends TranslationStrategy<TranslateLowGerman> {
    public TranslateLowGermanStrategy() {
        super(LowGermanProvider.class);
    }

    @Override
    public Class<TranslateLowGerman> getAnnotationClass() {
        return TranslateLowGerman.class;
    }
}
