package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.language.provider.LatinBelarusianProvider;
import io.bloomish.api.engine.initialization.initializer.StrategyPoolInitializer;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateLatinBelarusian;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class TranslateLatinBelarusianStrategy extends TranslationStrategy<TranslateLatinBelarusian> {
    public TranslateLatinBelarusianStrategy() {
        super(LatinBelarusianProvider.class);
    }

    @Override
    public Class<TranslateLatinBelarusian> getAnnotationClass() {
        return TranslateLatinBelarusian.class;
    }
}
