package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.language.provider.SlovakProvider;
import io.bloomish.api.engine.initialization.initializer.StrategyPoolInitializer;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateSlovak;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class TranslateSlovakStrategy extends TranslationStrategy<TranslateSlovak> {
    public TranslateSlovakStrategy() {
        super(SlovakProvider.class);
    }

    @Override
    public Class<TranslateSlovak> getAnnotationClass() {
        return TranslateSlovak.class;
    }
}
