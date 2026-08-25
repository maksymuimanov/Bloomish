package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.client.language.provider.SwissGermanProvider;
import io.bloomish.api.engine.initialization.initializer.StrategyInitializer;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateSwissGerman;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyInitializer.DEFAULT_FIELD_DATA)
public class TranslateSwissGermanStrategy extends TranslationStrategy<TranslateSwissGerman> {
    public TranslateSwissGermanStrategy() {
        super(SwissGermanProvider.class);
    }

    @Override
    public Class<TranslateSwissGerman> getAnnotationClass() {
        return TranslateSwissGerman.class;
    }
}
