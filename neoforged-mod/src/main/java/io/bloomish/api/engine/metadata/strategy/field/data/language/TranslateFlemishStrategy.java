package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.client.language.provider.FlemishProvider;
import io.bloomish.api.engine.initialization.initializer.StrategyInitializer;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateFlemish;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyInitializer.DEFAULT_FIELD_DATA)
public class TranslateFlemishStrategy extends TranslationStrategy<TranslateFlemish> {
    public TranslateFlemishStrategy() {
        super(FlemishProvider.class);
    }

    @Override
    public Class<TranslateFlemish> getAnnotationClass() {
        return TranslateFlemish.class;
    }
}
