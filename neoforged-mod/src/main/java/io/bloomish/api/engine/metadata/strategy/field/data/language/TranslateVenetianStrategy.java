package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.language.provider.VenetianProvider;
import io.bloomish.api.engine.initialization.initializer.StrategyPoolInitializer;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateVenetian;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class TranslateVenetianStrategy extends TranslationStrategy<TranslateVenetian> {
    public TranslateVenetianStrategy() {
        super(VenetianProvider.class);
    }

    @Override
    public Class<TranslateVenetian> getAnnotationClass() {
        return TranslateVenetian.class;
    }
}
