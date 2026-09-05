package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.client.language.provider.HindiProvider;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateHindi;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;
import io.bloomish.api.initialization.initializer.StrategyInitializer;

@Strategy(StrategyInitializer.DEFAULT_FIELD_DATA)
public class TranslateHindiStrategy extends TranslationStrategy<TranslateHindi> {
    public TranslateHindiStrategy() {
        super(HindiProvider.class);
    }

    @Override
    public Class<TranslateHindi> getAnnotationClass() {
        return TranslateHindi.class;
    }
}
