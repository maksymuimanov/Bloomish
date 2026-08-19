package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.language.provider.IrishProvider;
import io.bloomish.api.engine.initialization.initializer.StrategyInitializer;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateIrish;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyInitializer.DEFAULT_FIELD_DATA)
public class TranslateIrishStrategy extends TranslationStrategy<TranslateIrish> {
    public TranslateIrishStrategy() {
        super(IrishProvider.class);
    }

    @Override
    public Class<TranslateIrish> getAnnotationClass() {
        return TranslateIrish.class;
    }
}
