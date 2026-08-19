package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.language.provider.RusynProvider;
import io.bloomish.api.engine.initialization.initializer.StrategyInitializer;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateRusyn;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyInitializer.DEFAULT_FIELD_DATA)
public class TranslateRusynStrategy extends TranslationStrategy<TranslateRusyn> {
    public TranslateRusynStrategy() {
        super(RusynProvider.class);
    }

    @Override
    public Class<TranslateRusyn> getAnnotationClass() {
        return TranslateRusyn.class;
    }
}
