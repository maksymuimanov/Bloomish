package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.language.provider.LuxembourgishProvider;
import io.bloomish.api.engine.initialization.initializer.StrategyPoolInitializer;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateLuxembourgish;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class TranslateLuxembourgishStrategy extends TranslationStrategy<TranslateLuxembourgish> {
    public TranslateLuxembourgishStrategy() {
        super(LuxembourgishProvider.class);
    }

    @Override
    public Class<TranslateLuxembourgish> getAnnotationClass() {
        return TranslateLuxembourgish.class;
    }
}
