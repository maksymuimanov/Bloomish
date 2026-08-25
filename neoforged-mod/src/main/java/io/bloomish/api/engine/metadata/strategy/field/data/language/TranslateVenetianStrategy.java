package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.client.language.provider.VenetianProvider;
import io.bloomish.api.engine.initialization.initializer.StrategyInitializer;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateVenetian;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyInitializer.DEFAULT_FIELD_DATA)
public class TranslateVenetianStrategy extends TranslationStrategy<TranslateVenetian> {
    public TranslateVenetianStrategy() {
        super(VenetianProvider.class);
    }

    @Override
    public Class<TranslateVenetian> getAnnotationClass() {
        return TranslateVenetian.class;
    }
}
