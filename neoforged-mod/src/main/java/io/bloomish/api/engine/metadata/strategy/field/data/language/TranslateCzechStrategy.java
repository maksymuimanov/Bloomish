package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.client.language.provider.CzechProvider;
import io.bloomish.api.engine.initialization.initializer.StrategyInitializer;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateCzech;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyInitializer.DEFAULT_FIELD_DATA)
public class TranslateCzechStrategy extends TranslationStrategy<TranslateCzech> {
    public TranslateCzechStrategy() {
        super(CzechProvider.class);
    }

    @Override
    public Class<TranslateCzech> getAnnotationClass() {
        return TranslateCzech.class;
    }
}
