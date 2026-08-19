package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.language.provider.AsturianProvider;
import io.bloomish.api.engine.initialization.initializer.StrategyPoolInitializer;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateAsturian;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class TranslateAsturianStrategy extends TranslationStrategy<TranslateAsturian> {
    public TranslateAsturianStrategy() {
        super(AsturianProvider.class);
    }

    @Override
    public Class<TranslateAsturian> getAnnotationClass() {
        return TranslateAsturian.class;
    }
}
