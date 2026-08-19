package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.language.provider.LojbanProvider;
import io.bloomish.api.engine.initialization.initializer.StrategyPoolInitializer;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateLojban;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class TranslateLojbanStrategy extends TranslationStrategy<TranslateLojban> {
    public TranslateLojbanStrategy() {
        super(LojbanProvider.class);
    }

    @Override
    public Class<TranslateLojban> getAnnotationClass() {
        return TranslateLojban.class;
    }
}
