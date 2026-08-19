package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.language.provider.KyrgyzProvider;
import io.bloomish.api.engine.initialization.initializer.StrategyPoolInitializer;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateKyrgyz;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class TranslateKyrgyzStrategy extends TranslationStrategy<TranslateKyrgyz> {
    public TranslateKyrgyzStrategy() {
        super(KyrgyzProvider.class);
    }

    @Override
    public Class<TranslateKyrgyz> getAnnotationClass() {
        return TranslateKyrgyz.class;
    }
}
