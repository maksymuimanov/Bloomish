package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.language.provider.AustrianGermanProvider;
import io.bloomish.api.engine.initialization.initializer.StrategyInitializer;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateAustrianGerman;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyInitializer.DEFAULT_FIELD_DATA)
public class TranslateAustrianGermanStrategy extends TranslationStrategy<TranslateAustrianGerman> {
    public TranslateAustrianGermanStrategy() {
        super(AustrianGermanProvider.class);
    }

    @Override
    public Class<TranslateAustrianGerman> getAnnotationClass() {
        return TranslateAustrianGerman.class;
    }
}
