package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.client.language.provider.DanishProvider;
import io.bloomish.api.engine.initialization.initializer.StrategyInitializer;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateDanish;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyInitializer.DEFAULT_FIELD_DATA)
public class TranslateDanishStrategy extends TranslationStrategy<TranslateDanish> {
    public TranslateDanishStrategy() {
        super(DanishProvider.class);
    }

    @Override
    public Class<TranslateDanish> getAnnotationClass() {
        return TranslateDanish.class;
    }
}
