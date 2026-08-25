package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.client.language.provider.IgboProvider;
import io.bloomish.api.engine.initialization.initializer.StrategyInitializer;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateIgbo;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyInitializer.DEFAULT_FIELD_DATA)
public class TranslateIgboStrategy extends TranslationStrategy<TranslateIgbo> {
    public TranslateIgboStrategy() {
        super(IgboProvider.class);
    }

    @Override
    public Class<TranslateIgbo> getAnnotationClass() {
        return TranslateIgbo.class;
    }
}
