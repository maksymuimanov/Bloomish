package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.client.language.provider.SerbianProvider;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateSerbian;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;
import io.bloomish.api.initialization.initializer.StrategyInitializer;

@Strategy(StrategyInitializer.DEFAULT_FIELD_DATA)
public class TranslateSerbianStrategy extends TranslationStrategy<TranslateSerbian> {
    public TranslateSerbianStrategy() {
        super(SerbianProvider.class);
    }

    @Override
    public Class<TranslateSerbian> getAnnotationClass() {
        return TranslateSerbian.class;
    }
}
