package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.client.language.provider.BosnianProvider;
import io.bloomish.api.engine.initialization.initializer.StrategyInitializer;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateBosnian;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyInitializer.DEFAULT_FIELD_DATA)
public class TranslateBosnianStrategy extends TranslationStrategy<TranslateBosnian> {
    public TranslateBosnianStrategy() {
        super(BosnianProvider.class);
    }

    @Override
    public Class<TranslateBosnian> getAnnotationClass() {
        return TranslateBosnian.class;
    }
}
