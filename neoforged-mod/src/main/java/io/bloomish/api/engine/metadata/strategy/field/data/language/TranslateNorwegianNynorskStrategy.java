package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.client.language.provider.NorwegianNynorskProvider;
import io.bloomish.api.engine.initialization.initializer.StrategyInitializer;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateNorwegianNynorsk;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyInitializer.DEFAULT_FIELD_DATA)
public class TranslateNorwegianNynorskStrategy extends TranslationStrategy<TranslateNorwegianNynorsk> {
    public TranslateNorwegianNynorskStrategy() {
        super(NorwegianNynorskProvider.class);
    }

    @Override
    public Class<TranslateNorwegianNynorsk> getAnnotationClass() {
        return TranslateNorwegianNynorsk.class;
    }
}
