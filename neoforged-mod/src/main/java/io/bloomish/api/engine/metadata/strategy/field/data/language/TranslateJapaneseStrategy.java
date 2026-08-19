package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.language.provider.JapaneseProvider;
import io.bloomish.api.engine.initialization.initializer.StrategyPoolInitializer;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateJapanese;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class TranslateJapaneseStrategy extends TranslationStrategy<TranslateJapanese> {
    public TranslateJapaneseStrategy() {
        super(JapaneseProvider.class);
    }

    @Override
    public Class<TranslateJapanese> getAnnotationClass() {
        return TranslateJapanese.class;
    }
}
