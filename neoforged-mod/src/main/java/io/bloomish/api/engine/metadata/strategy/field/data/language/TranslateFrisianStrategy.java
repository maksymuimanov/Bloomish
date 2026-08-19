package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.language.provider.FrisianProvider;
import io.bloomish.api.engine.initialization.initializer.StrategyInitializer;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateFrisian;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;

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
