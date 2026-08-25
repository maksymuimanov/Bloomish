package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.client.language.provider.ScottishGaelicProvider;
import io.bloomish.api.engine.initialization.initializer.StrategyInitializer;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateScottishGaelic;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyInitializer.DEFAULT_FIELD_DATA)
public class TranslateScottishGaelicStrategy extends TranslationStrategy<TranslateScottishGaelic> {
    public TranslateScottishGaelicStrategy() {
        super(ScottishGaelicProvider.class);
    }

    @Override
    public Class<TranslateScottishGaelic> getAnnotationClass() {
        return TranslateScottishGaelic.class;
    }
}
