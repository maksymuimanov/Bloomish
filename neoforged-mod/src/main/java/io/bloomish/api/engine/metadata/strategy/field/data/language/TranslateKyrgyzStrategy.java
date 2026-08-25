package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.client.language.provider.KyrgyzProvider;
import io.bloomish.api.engine.initialization.initializer.StrategyInitializer;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateKyrgyz;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyInitializer.DEFAULT_FIELD_DATA)
public class TranslateKyrgyzStrategy extends TranslationStrategy<TranslateKyrgyz> {
    public TranslateKyrgyzStrategy() {
        super(KyrgyzProvider.class);
    }

    @Override
    public Class<TranslateKyrgyz> getAnnotationClass() {
        return TranslateKyrgyz.class;
    }
}
