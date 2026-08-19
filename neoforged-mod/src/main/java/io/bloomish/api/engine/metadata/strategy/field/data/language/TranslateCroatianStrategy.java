package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.language.provider.CroatianProvider;
import io.bloomish.api.engine.initialization.initializer.StrategyPoolInitializer;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateCroatian;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class TranslateCroatianStrategy extends TranslationStrategy<TranslateCroatian> {
    public TranslateCroatianStrategy() {
        super(CroatianProvider.class);
    }

    @Override
    public Class<TranslateCroatian> getAnnotationClass() {
        return TranslateCroatian.class;
    }
}
