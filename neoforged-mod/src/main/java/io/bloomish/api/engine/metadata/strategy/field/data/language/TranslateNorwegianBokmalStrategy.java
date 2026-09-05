package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.client.language.provider.NorwegianBokmalProvider;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateNorwegianBokmal;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;
import io.bloomish.api.initialization.initializer.StrategyInitializer;

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
