package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.language.provider.KazakhProvider;
import io.bloomish.api.engine.initialization.initializer.StrategyPoolInitializer;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateKazakh;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class TranslateKazakhStrategy extends TranslationStrategy<TranslateKazakh> {
    public TranslateKazakhStrategy() {
        super(KazakhProvider.class);
    }

    @Override
    public Class<TranslateKazakh> getAnnotationClass() {
        return TranslateKazakh.class;
    }
}
