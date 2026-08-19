package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.language.provider.ShakespeareanEnglishProvider;
import io.bloomish.api.engine.initialization.initializer.StrategyPoolInitializer;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateShakespeareanEnglish;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class TranslateShakespeareanEnglishStrategy extends TranslationStrategy<TranslateShakespeareanEnglish> {
    public TranslateShakespeareanEnglishStrategy() {
        super(ShakespeareanEnglishProvider.class);
    }

    @Override
    public Class<TranslateShakespeareanEnglish> getAnnotationClass() {
        return TranslateShakespeareanEnglish.class;
    }
}
