package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.client.language.provider.NorthernSamiProvider;
import io.bloomish.api.engine.initialization.initializer.StrategyInitializer;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateNorthernSami;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyInitializer.DEFAULT_FIELD_DATA)
public class TranslateNorthernSamiStrategy extends TranslationStrategy<TranslateNorthernSami> {
    public TranslateNorthernSamiStrategy() {
        super(NorthernSamiProvider.class);
    }

    @Override
    public Class<TranslateNorthernSami> getAnnotationClass() {
        return TranslateNorthernSami.class;
    }
}
