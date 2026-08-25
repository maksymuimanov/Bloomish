package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.client.language.provider.LatinSerbianProvider;
import io.bloomish.api.engine.initialization.initializer.StrategyInitializer;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateLatinSerbian;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyInitializer.DEFAULT_FIELD_DATA)
public class TranslateLatinSerbianStrategy extends TranslationStrategy<TranslateLatinSerbian> {
    public TranslateLatinSerbianStrategy() {
        super(LatinSerbianProvider.class);
    }

    @Override
    public Class<TranslateLatinSerbian> getAnnotationClass() {
        return TranslateLatinSerbian.class;
    }
}
