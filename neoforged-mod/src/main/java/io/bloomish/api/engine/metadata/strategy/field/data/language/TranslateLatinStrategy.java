package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.language.provider.LatinProvider;
import io.bloomish.api.engine.initialization.initializer.StrategyInitializer;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateLatin;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyInitializer.DEFAULT_FIELD_DATA)
public class TranslateLatinStrategy extends TranslationStrategy<TranslateLatin> {
    public TranslateLatinStrategy() {
        super(LatinProvider.class);
    }

    @Override
    public Class<TranslateLatin> getAnnotationClass() {
        return TranslateLatin.class;
    }
}
