package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.language.provider.NahuatlProvider;
import io.bloomish.api.engine.initialization.initializer.StrategyPoolInitializer;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateNahuatl;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class TranslateNahuatlStrategy extends TranslationStrategy<TranslateNahuatl> {
    public TranslateNahuatlStrategy() {
        super(NahuatlProvider.class);
    }

    @Override
    public Class<TranslateNahuatl> getAnnotationClass() {
        return TranslateNahuatl.class;
    }
}
