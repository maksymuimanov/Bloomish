package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.language.provider.CanadianFrenchProvider;
import io.bloomish.api.engine.initialization.initializer.StrategyInitializer;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateCanadianFrench;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyInitializer.DEFAULT_FIELD_DATA)
public class TranslateCanadianFrenchStrategy extends TranslationStrategy<TranslateCanadianFrench> {
    public TranslateCanadianFrenchStrategy() {
        super(CanadianFrenchProvider.class);
    }

    @Override
    public Class<TranslateCanadianFrench> getAnnotationClass() {
        return TranslateCanadianFrench.class;
    }
}
