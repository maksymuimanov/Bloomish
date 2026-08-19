package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.language.provider.CornishProvider;
import io.bloomish.api.engine.initialization.initializer.StrategyInitializer;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateCornish;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyInitializer.DEFAULT_FIELD_DATA)
public class TranslateCornishStrategy extends TranslationStrategy<TranslateCornish> {
    public TranslateCornishStrategy() {
        super(CornishProvider.class);
    }

    @Override
    public Class<TranslateCornish> getAnnotationClass() {
        return TranslateCornish.class;
    }
}
