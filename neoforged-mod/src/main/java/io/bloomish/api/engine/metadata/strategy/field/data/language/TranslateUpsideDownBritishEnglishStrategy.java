package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.language.provider.UpsideDownBritishEnglishProvider;
import io.bloomish.api.engine.initialization.initializer.StrategyPoolInitializer;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateUpsideDownBritishEnglish;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class TranslateUpsideDownBritishEnglishStrategy extends TranslationStrategy<TranslateUpsideDownBritishEnglish> {
    public TranslateUpsideDownBritishEnglishStrategy() {
        super(UpsideDownBritishEnglishProvider.class);
    }

    @Override
    public Class<TranslateUpsideDownBritishEnglish> getAnnotationClass() {
        return TranslateUpsideDownBritishEnglish.class;
    }
}
