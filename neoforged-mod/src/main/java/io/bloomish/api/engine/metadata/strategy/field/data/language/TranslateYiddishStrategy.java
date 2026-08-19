package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.language.provider.YiddishProvider;
import io.bloomish.api.engine.initialization.initializer.StrategyInitializer;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateYiddish;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyInitializer.DEFAULT_FIELD_DATA)
public class TranslateYiddishStrategy extends TranslationStrategy<TranslateYiddish> {
    public TranslateYiddishStrategy() {
        super(YiddishProvider.class);
    }

    @Override
    public Class<TranslateYiddish> getAnnotationClass() {
        return TranslateYiddish.class;
    }
}
