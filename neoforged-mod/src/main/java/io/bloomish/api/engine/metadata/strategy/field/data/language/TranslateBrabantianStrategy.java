package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.language.provider.BrabantianProvider;
import io.bloomish.api.engine.initialization.initializer.StrategyPoolInitializer;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateBrabantian;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class TranslateBrabantianStrategy extends TranslationStrategy<TranslateBrabantian> {
    public TranslateBrabantianStrategy() {
        super(BrabantianProvider.class);
    }

    @Override
    public Class<TranslateBrabantian> getAnnotationClass() {
        return TranslateBrabantian.class;
    }
}
