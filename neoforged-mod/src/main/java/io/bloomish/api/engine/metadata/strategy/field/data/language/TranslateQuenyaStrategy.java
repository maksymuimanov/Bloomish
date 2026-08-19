package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.language.provider.QuenyaProvider;
import io.bloomish.api.engine.initialization.initializer.StrategyPoolInitializer;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateQuenya;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class TranslateQuenyaStrategy extends TranslationStrategy<TranslateQuenya> {
    public TranslateQuenyaStrategy() {
        super(QuenyaProvider.class);
    }

    @Override
    public Class<TranslateQuenya> getAnnotationClass() {
        return TranslateQuenya.class;
    }
}
