package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.language.provider.ValencianProvider;
import io.bloomish.api.engine.initialization.initializer.StrategyPoolInitializer;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateValencian;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class TranslateValencianStrategy extends TranslationStrategy<TranslateValencian> {
    public TranslateValencianStrategy() {
        super(ValencianProvider.class);
    }

    @Override
    public Class<TranslateValencian> getAnnotationClass() {
        return TranslateValencian.class;
    }
}
