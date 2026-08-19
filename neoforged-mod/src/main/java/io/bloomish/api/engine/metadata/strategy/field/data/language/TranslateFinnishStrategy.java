package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.language.provider.FinnishProvider;
import io.bloomish.api.engine.initialization.initializer.StrategyInitializer;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateFinnish;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyInitializer.DEFAULT_FIELD_DATA)
public class TranslateFinnishStrategy extends TranslationStrategy<TranslateFinnish> {
    public TranslateFinnishStrategy() {
        super(FinnishProvider.class);
    }

    @Override
    public Class<TranslateFinnish> getAnnotationClass() {
        return TranslateFinnish.class;
    }
}
