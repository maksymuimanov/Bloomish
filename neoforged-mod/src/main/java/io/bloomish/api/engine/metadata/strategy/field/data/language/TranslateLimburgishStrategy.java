package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.client.language.provider.LimburgishProvider;
import io.bloomish.api.engine.initialization.initializer.StrategyInitializer;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateLimburgish;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyInitializer.DEFAULT_FIELD_DATA)
public class TranslateLimburgishStrategy extends TranslationStrategy<TranslateLimburgish> {
    public TranslateLimburgishStrategy() {
        super(LimburgishProvider.class);
    }

    @Override
    public Class<TranslateLimburgish> getAnnotationClass() {
        return TranslateLimburgish.class;
    }
}
