package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.client.language.provider.TurkishProvider;
import io.bloomish.api.engine.initialization.initializer.StrategyInitializer;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateTurkish;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyInitializer.DEFAULT_FIELD_DATA)
public class TranslateTurkishStrategy extends TranslationStrategy<TranslateTurkish> {
    public TranslateTurkishStrategy() {
        super(TurkishProvider.class);
    }

    @Override
    public Class<TranslateTurkish> getAnnotationClass() {
        return TranslateTurkish.class;
    }
}
