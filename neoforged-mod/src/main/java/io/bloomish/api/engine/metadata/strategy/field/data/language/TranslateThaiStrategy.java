package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.client.language.provider.ThaiProvider;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateThai;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;
import io.bloomish.api.initialization.initializer.StrategyInitializer;

@Strategy(StrategyInitializer.DEFAULT_FIELD_DATA)
public class TranslateThaiStrategy extends TranslationStrategy<TranslateThai> {
    public TranslateThaiStrategy() {
        super(ThaiProvider.class);
    }

    @Override
    public Class<TranslateThai> getAnnotationClass() {
        return TranslateThai.class;
    }
}
