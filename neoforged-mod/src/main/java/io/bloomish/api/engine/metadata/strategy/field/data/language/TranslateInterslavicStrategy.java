package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.client.language.provider.InterslavicProvider;
import io.bloomish.api.engine.initialization.initializer.StrategyInitializer;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateInterslavic;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyInitializer.DEFAULT_FIELD_DATA)
public class TranslateInterslavicStrategy extends TranslationStrategy<TranslateInterslavic> {
    public TranslateInterslavicStrategy() {
        super(InterslavicProvider.class);
    }

    @Override
    public Class<TranslateInterslavic> getAnnotationClass() {
        return TranslateInterslavic.class;
    }
}
