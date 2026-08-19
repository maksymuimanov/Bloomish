package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.language.provider.CzechProvider;
import io.bloomish.api.engine.initialization.initializer.StrategyPoolInitializer;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateCzech;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class TranslateCzechStrategy extends TranslationStrategy<TranslateCzech> {
    public TranslateCzechStrategy() {
        super(CzechProvider.class);
    }

    @Override
    public Class<TranslateCzech> getAnnotationClass() {
        return TranslateCzech.class;
    }
}
