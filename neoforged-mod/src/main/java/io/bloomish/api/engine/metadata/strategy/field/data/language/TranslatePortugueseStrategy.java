package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.language.provider.PortugueseProvider;
import io.bloomish.api.engine.initialization.initializer.StrategyPoolInitializer;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslatePortuguese;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class TranslatePortugueseStrategy extends TranslationStrategy<TranslatePortuguese> {
    public TranslatePortugueseStrategy() {
        super(PortugueseProvider.class);
    }

    @Override
    public Class<TranslatePortuguese> getAnnotationClass() {
        return TranslatePortuguese.class;
    }
}
