package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.language.provider.BasqueProvider;
import io.bloomish.api.engine.initialization.initializer.StrategyInitializer;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateBasque;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyInitializer.DEFAULT_FIELD_DATA)
public class TranslateBasqueStrategy extends TranslationStrategy<TranslateBasque> {
    public TranslateBasqueStrategy() {
        super(BasqueProvider.class);
    }

    @Override
    public Class<TranslateBasque> getAnnotationClass() {
        return TranslateBasque.class;
    }
}
