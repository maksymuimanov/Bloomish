package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.language.provider.NorwegianBokmalProvider;
import io.bloomish.api.engine.initialization.initializer.StrategyInitializer;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateNorwegianBokmal;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyInitializer.DEFAULT_FIELD_DATA)
public class TranslateNorwegianBokmalStrategy extends TranslationStrategy<TranslateNorwegianBokmal> {
    public TranslateNorwegianBokmalStrategy() {
        super(NorwegianBokmalProvider.class);
    }

    @Override
    public Class<TranslateNorwegianBokmal> getAnnotationClass() {
        return TranslateNorwegianBokmal.class;
    }
}
