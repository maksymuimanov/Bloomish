package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.language.provider.PersianProvider;
import io.bloomish.api.engine.initialization.initializer.StrategyPoolInitializer;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslatePersian;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class TranslatePersianStrategy extends TranslationStrategy<TranslatePersian> {
    public TranslatePersianStrategy() {
        super(PersianProvider.class);
    }

    @Override
    public Class<TranslatePersian> getAnnotationClass() {
        return TranslatePersian.class;
    }
}
