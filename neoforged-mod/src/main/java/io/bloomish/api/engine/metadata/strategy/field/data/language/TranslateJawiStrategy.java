package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.client.language.provider.JawiProvider;
import io.bloomish.api.engine.initialization.initializer.StrategyInitializer;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateJawi;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyInitializer.DEFAULT_FIELD_DATA)
public class TranslateJawiStrategy extends TranslationStrategy<TranslateJawi> {
    public TranslateJawiStrategy() {
        super(JawiProvider.class);
    }

    @Override
    public Class<TranslateJawi> getAnnotationClass() {
        return TranslateJawi.class;
    }
}
