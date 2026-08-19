package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.language.provider.PirateEnglishProvider;
import io.bloomish.api.engine.initialization.initializer.StrategyPoolInitializer;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslatePirateEnglish;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class TranslatePirateEnglishStrategy extends TranslationStrategy<TranslatePirateEnglish> {
    public TranslatePirateEnglishStrategy() {
        super(PirateEnglishProvider.class);
    }

    @Override
    public Class<TranslatePirateEnglish> getAnnotationClass() {
        return TranslatePirateEnglish.class;
    }
}
