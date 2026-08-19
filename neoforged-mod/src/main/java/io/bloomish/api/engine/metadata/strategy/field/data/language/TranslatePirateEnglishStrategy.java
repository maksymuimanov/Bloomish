package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.language.provider.PirateEnglishProvider;
import io.bloomish.api.engine.initialization.initializer.StrategyInitializer;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslatePirateEnglish;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyInitializer.DEFAULT_FIELD_DATA)
public class TranslatePirateEnglishStrategy extends TranslationStrategy<TranslatePirateEnglish> {
    public TranslatePirateEnglishStrategy() {
        super(PirateEnglishProvider.class);
    }

    @Override
    public Class<TranslatePirateEnglish> getAnnotationClass() {
        return TranslatePirateEnglish.class;
    }
}
