package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.language.provider.KlingonProvider;
import io.bloomish.api.engine.initialization.initializer.StrategyInitializer;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateKlingon;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyInitializer.DEFAULT_FIELD_DATA)
public class TranslateKlingonStrategy extends TranslationStrategy<TranslateKlingon> {
    public TranslateKlingonStrategy() {
        super(KlingonProvider.class);
    }

    @Override
    public Class<TranslateKlingon> getAnnotationClass() {
        return TranslateKlingon.class;
    }
}
