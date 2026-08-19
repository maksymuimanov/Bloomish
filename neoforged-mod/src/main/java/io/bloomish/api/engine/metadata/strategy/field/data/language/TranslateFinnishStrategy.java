package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.language.provider.FinnishProvider;
import io.bloomish.api.engine.initialization.initializer.StrategyPoolInitializer;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateFinnish;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class TranslateFinnishStrategy extends TranslationStrategy<TranslateFinnish> {
    public TranslateFinnishStrategy() {
        super(FinnishProvider.class);
    }

    @Override
    public Class<TranslateFinnish> getAnnotationClass() {
        return TranslateFinnish.class;
    }
}
