package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.client.language.provider.ViossaProvider;
import io.bloomish.api.engine.initialization.initializer.StrategyInitializer;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateViossa;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyInitializer.DEFAULT_FIELD_DATA)
public class TranslateViossaStrategy extends TranslationStrategy<TranslateViossa> {
    public TranslateViossaStrategy() {
        super(ViossaProvider.class);
    }

    @Override
    public Class<TranslateViossa> getAnnotationClass() {
        return TranslateViossa.class;
    }
}
