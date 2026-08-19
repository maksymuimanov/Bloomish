package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.language.provider.YakutProvider;
import io.bloomish.api.engine.initialization.initializer.StrategyInitializer;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateYakut;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyInitializer.DEFAULT_FIELD_DATA)
public class TranslateYakutStrategy extends TranslationStrategy<TranslateYakut> {
    public TranslateYakutStrategy() {
        super(YakutProvider.class);
    }

    @Override
    public Class<TranslateYakut> getAnnotationClass() {
        return TranslateYakut.class;
    }
}
