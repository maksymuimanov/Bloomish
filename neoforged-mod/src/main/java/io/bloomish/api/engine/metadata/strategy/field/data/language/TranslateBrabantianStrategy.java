package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.client.language.provider.BrabantianProvider;
import io.bloomish.api.engine.initialization.initializer.StrategyInitializer;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateBrabantian;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyInitializer.DEFAULT_FIELD_DATA)
public class TranslateBrabantianStrategy extends TranslationStrategy<TranslateBrabantian> {
    public TranslateBrabantianStrategy() {
        super(BrabantianProvider.class);
    }

    @Override
    public Class<TranslateBrabantian> getAnnotationClass() {
        return TranslateBrabantian.class;
    }
}
