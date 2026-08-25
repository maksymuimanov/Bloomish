package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.client.language.provider.TamilProvider;
import io.bloomish.api.engine.initialization.initializer.StrategyInitializer;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateTamil;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyInitializer.DEFAULT_FIELD_DATA)
public class TranslateTamilStrategy extends TranslationStrategy<TranslateTamil> {
    public TranslateTamilStrategy() {
        super(TamilProvider.class);
    }

    @Override
    public Class<TranslateTamil> getAnnotationClass() {
        return TranslateTamil.class;
    }
}
