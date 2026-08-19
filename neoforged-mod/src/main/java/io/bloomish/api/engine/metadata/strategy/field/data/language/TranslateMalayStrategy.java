package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.language.provider.MalayProvider;
import io.bloomish.api.engine.initialization.initializer.StrategyInitializer;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateMalay;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyInitializer.DEFAULT_FIELD_DATA)
public class TranslateMalayStrategy extends TranslationStrategy<TranslateMalay> {
    public TranslateMalayStrategy() {
        super(MalayProvider.class);
    }

    @Override
    public Class<TranslateMalay> getAnnotationClass() {
        return TranslateMalay.class;
    }
}
