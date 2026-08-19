package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.language.provider.BosnianProvider;
import io.bloomish.api.engine.initialization.initializer.StrategyPoolInitializer;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateBosnian;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class TranslateBosnianStrategy extends TranslationStrategy<TranslateBosnian> {
    public TranslateBosnianStrategy() {
        super(BosnianProvider.class);
    }

    @Override
    public Class<TranslateBosnian> getAnnotationClass() {
        return TranslateBosnian.class;
    }
}
