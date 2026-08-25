package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.client.language.provider.NahuatlProvider;
import io.bloomish.api.engine.initialization.initializer.StrategyInitializer;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateNahuatl;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyInitializer.DEFAULT_FIELD_DATA)
public class TranslateNahuatlStrategy extends TranslationStrategy<TranslateNahuatl> {
    public TranslateNahuatlStrategy() {
        super(NahuatlProvider.class);
    }

    @Override
    public Class<TranslateNahuatl> getAnnotationClass() {
        return TranslateNahuatl.class;
    }
}
