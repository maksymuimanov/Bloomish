package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.client.language.provider.FrenchProvider;
import io.bloomish.api.engine.initialization.initializer.StrategyInitializer;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateFrench;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyInitializer.DEFAULT_FIELD_DATA)
public class TranslateFrenchStrategy extends TranslationStrategy<TranslateFrench> {
    public TranslateFrenchStrategy() {
        super(FrenchProvider.class);
    }

    @Override
    public Class<TranslateFrench> getAnnotationClass() {
        return TranslateFrench.class;
    }
}
