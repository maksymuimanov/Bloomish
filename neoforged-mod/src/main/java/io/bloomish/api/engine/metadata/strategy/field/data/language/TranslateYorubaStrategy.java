package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.language.provider.YorubaProvider;
import io.bloomish.api.engine.initialization.initializer.StrategyPoolInitializer;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateYoruba;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class TranslateYorubaStrategy extends TranslationStrategy<TranslateYoruba> {
    public TranslateYorubaStrategy() {
        super(YorubaProvider.class);
    }

    @Override
    public Class<TranslateYoruba> getAnnotationClass() {
        return TranslateYoruba.class;
    }
}
