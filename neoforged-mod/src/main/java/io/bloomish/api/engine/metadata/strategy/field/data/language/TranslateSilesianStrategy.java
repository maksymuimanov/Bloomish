package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.language.provider.SilesianProvider;
import io.bloomish.api.engine.initialization.initializer.StrategyPoolInitializer;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateSilesian;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class TranslateSilesianStrategy extends TranslationStrategy<TranslateSilesian> {
    public TranslateSilesianStrategy() {
        super(SilesianProvider.class);
    }

    @Override
    public Class<TranslateSilesian> getAnnotationClass() {
        return TranslateSilesian.class;
    }
}
