package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.language.provider.BretonProvider;
import io.bloomish.api.engine.initialization.initializer.StrategyInitializer;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateBreton;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyInitializer.DEFAULT_FIELD_DATA)
public class TranslateBretonStrategy extends TranslationStrategy<TranslateBreton> {
    public TranslateBretonStrategy() {
        super(BretonProvider.class);
    }

    @Override
    public Class<TranslateBreton> getAnnotationClass() {
        return TranslateBreton.class;
    }
}
