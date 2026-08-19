package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.language.provider.TagalogProvider;
import io.bloomish.api.engine.initialization.initializer.StrategyInitializer;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateTagalog;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyInitializer.DEFAULT_FIELD_DATA)
public class TranslateTagalogStrategy extends TranslationStrategy<TranslateTagalog> {
    public TranslateTagalogStrategy() {
        super(TagalogProvider.class);
    }

    @Override
    public Class<TranslateTagalog> getAnnotationClass() {
        return TranslateTagalog.class;
    }
}
