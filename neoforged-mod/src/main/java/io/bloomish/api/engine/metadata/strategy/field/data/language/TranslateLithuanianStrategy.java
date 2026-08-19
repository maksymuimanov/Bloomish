package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.language.provider.LithuanianProvider;
import io.bloomish.api.engine.initialization.initializer.StrategyPoolInitializer;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateLithuanian;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class TranslateLithuanianStrategy extends TranslationStrategy<TranslateLithuanian> {
    public TranslateLithuanianStrategy() {
        super(LithuanianProvider.class);
    }

    @Override
    public Class<TranslateLithuanian> getAnnotationClass() {
        return TranslateLithuanian.class;
    }
}
