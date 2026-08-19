package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.language.provider.WelshProvider;
import io.bloomish.api.engine.initialization.initializer.StrategyPoolInitializer;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateWelsh;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class TranslateWelshStrategy extends TranslationStrategy<TranslateWelsh> {
    public TranslateWelshStrategy() {
        super(WelshProvider.class);
    }

    @Override
    public Class<TranslateWelsh> getAnnotationClass() {
        return TranslateWelsh.class;
    }
}
