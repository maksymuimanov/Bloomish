package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.client.language.provider.QuenyaProvider;
import io.bloomish.api.engine.initialization.initializer.StrategyInitializer;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateQuenya;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyInitializer.DEFAULT_FIELD_DATA)
public class TranslateQuenyaStrategy extends TranslationStrategy<TranslateQuenya> {
    public TranslateQuenyaStrategy() {
        super(QuenyaProvider.class);
    }

    @Override
    public Class<TranslateQuenya> getAnnotationClass() {
        return TranslateQuenya.class;
    }
}
