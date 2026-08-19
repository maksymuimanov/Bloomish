package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.language.provider.GreekProvider;
import io.bloomish.api.engine.initialization.initializer.StrategyPoolInitializer;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateGreek;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class TranslateGreekStrategy extends TranslationStrategy<TranslateGreek> {
    public TranslateGreekStrategy() {
        super(GreekProvider.class);
    }

    @Override
    public Class<TranslateGreek> getAnnotationClass() {
        return TranslateGreek.class;
    }
}
