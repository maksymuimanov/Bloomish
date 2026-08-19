package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.language.provider.BritishEnglishProvider;
import io.bloomish.api.engine.initialization.initializer.StrategyInitializer;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateBritishEnglish;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyInitializer.DEFAULT_FIELD_DATA)
public class TranslateBritishEnglishStrategy extends TranslationStrategy<TranslateBritishEnglish> {
    public TranslateBritishEnglishStrategy() {
        super(BritishEnglishProvider.class);
    }

    @Override
    public Class<TranslateBritishEnglish> getAnnotationClass() {
        return TranslateBritishEnglish.class;
    }
}
