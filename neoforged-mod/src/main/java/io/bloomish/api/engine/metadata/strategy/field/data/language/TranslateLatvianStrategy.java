package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.language.provider.LatvianProvider;
import io.bloomish.api.engine.initialization.initializer.StrategyInitializer;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateLatvian;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyInitializer.DEFAULT_FIELD_DATA)
public class TranslateLatvianStrategy extends TranslationStrategy<TranslateLatvian> {
    public TranslateLatvianStrategy() {
        super(LatvianProvider.class);
    }

    @Override
    public Class<TranslateLatvian> getAnnotationClass() {
        return TranslateLatvian.class;
    }
}
