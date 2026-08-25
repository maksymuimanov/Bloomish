package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.client.language.provider.HungarianProvider;
import io.bloomish.api.engine.initialization.initializer.StrategyInitializer;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateHungarian;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyInitializer.DEFAULT_FIELD_DATA)
public class TranslateHungarianStrategy extends TranslationStrategy<TranslateHungarian> {
    public TranslateHungarianStrategy() {
        super(HungarianProvider.class);
    }

    @Override
    public Class<TranslateHungarian> getAnnotationClass() {
        return TranslateHungarian.class;
    }
}
