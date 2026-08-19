package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.language.provider.GalicianProvider;
import io.bloomish.api.engine.initialization.initializer.StrategyPoolInitializer;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateGalician;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class TranslateGalicianStrategy extends TranslationStrategy<TranslateGalician> {
    public TranslateGalicianStrategy() {
        super(GalicianProvider.class);
    }

    @Override
    public Class<TranslateGalician> getAnnotationClass() {
        return TranslateGalician.class;
    }
}
