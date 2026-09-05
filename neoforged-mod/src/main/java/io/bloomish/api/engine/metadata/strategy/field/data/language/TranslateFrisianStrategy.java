package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.client.language.provider.FrisianProvider;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateFrisian;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;
import io.bloomish.api.initialization.initializer.StrategyInitializer;

@Strategy(StrategyInitializer.DEFAULT_FIELD_DATA)
public class TranslateFrisianStrategy extends TranslationStrategy<TranslateFrisian> {
    public TranslateFrisianStrategy() {
        super(FrisianProvider.class);
    }

    @Override
    public Class<TranslateFrisian> getAnnotationClass() {
        return TranslateFrisian.class;
    }
}
