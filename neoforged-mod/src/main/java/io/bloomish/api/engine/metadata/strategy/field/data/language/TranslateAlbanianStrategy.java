package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.client.language.provider.AlbanianProvider;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateAlbanian;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;
import io.bloomish.api.initialization.initializer.StrategyInitializer;

@Strategy(StrategyInitializer.DEFAULT_FIELD_DATA)
public class TranslateAlbanianStrategy extends TranslationStrategy<TranslateAlbanian> {
    public TranslateAlbanianStrategy() {
        super(AlbanianProvider.class);
    }

    @Override
    public Class<TranslateAlbanian> getAnnotationClass() {
        return TranslateAlbanian.class;
    }
}
