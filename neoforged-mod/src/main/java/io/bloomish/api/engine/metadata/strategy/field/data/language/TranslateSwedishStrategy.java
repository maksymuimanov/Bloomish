package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.language.provider.SwedishProvider;
import io.bloomish.api.engine.initialization.initializer.StrategyPoolInitializer;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateSwedish;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class TranslateSwedishStrategy extends TranslationStrategy<TranslateSwedish> {
    public TranslateSwedishStrategy() {
        super(SwedishProvider.class);
    }

    @Override
    public Class<TranslateSwedish> getAnnotationClass() {
        return TranslateSwedish.class;
    }
}
