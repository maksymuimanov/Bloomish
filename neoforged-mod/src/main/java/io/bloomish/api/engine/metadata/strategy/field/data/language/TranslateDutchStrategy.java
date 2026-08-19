package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.language.provider.DutchProvider;
import io.bloomish.api.engine.initialization.initializer.StrategyPoolInitializer;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateDutch;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class TranslateDutchStrategy extends TranslationStrategy<TranslateDutch> {
    public TranslateDutchStrategy() {
        super(DutchProvider.class);
    }

    @Override
    public Class<TranslateDutch> getAnnotationClass() {
        return TranslateDutch.class;
    }
}
