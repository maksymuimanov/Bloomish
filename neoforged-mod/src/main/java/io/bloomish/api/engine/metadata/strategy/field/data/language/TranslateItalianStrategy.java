package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.language.provider.ItalianProvider;
import io.bloomish.api.engine.initialization.initializer.StrategyPoolInitializer;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateItalian;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class TranslateItalianStrategy extends TranslationStrategy<TranslateItalian> {
    public TranslateItalianStrategy() {
        super(ItalianProvider.class);
    }

    @Override
    public Class<TranslateItalian> getAnnotationClass() {
        return TranslateItalian.class;
    }
}
