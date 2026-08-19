package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.language.provider.CatalanProvider;
import io.bloomish.api.engine.initialization.initializer.StrategyInitializer;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateCatalan;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyInitializer.DEFAULT_FIELD_DATA)
public class TranslateCatalanStrategy extends TranslationStrategy<TranslateCatalan> {
    public TranslateCatalanStrategy() {
        super(CatalanProvider.class);
    }

    @Override
    public Class<TranslateCatalan> getAnnotationClass() {
        return TranslateCatalan.class;
    }
}
