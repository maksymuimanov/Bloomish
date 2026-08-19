package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.language.provider.NorwegianNynorskProvider;
import io.bloomish.api.engine.initialization.initializer.StrategyPoolInitializer;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateNorwegianNynorsk;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class TranslateNorwegianNynorskStrategy extends TranslationStrategy<TranslateNorwegianNynorsk> {
    public TranslateNorwegianNynorskStrategy() {
        super(NorwegianNynorskProvider.class);
    }

    @Override
    public Class<TranslateNorwegianNynorsk> getAnnotationClass() {
        return TranslateNorwegianNynorsk.class;
    }
}
