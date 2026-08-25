package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.client.language.provider.UpperSaxonGermanProvider;
import io.bloomish.api.engine.initialization.initializer.StrategyInitializer;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateUpperSaxonGerman;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyInitializer.DEFAULT_FIELD_DATA)
public class TranslateUpperSaxonGermanStrategy extends TranslationStrategy<TranslateUpperSaxonGerman> {
    public TranslateUpperSaxonGermanStrategy() {
        super(UpperSaxonGermanProvider.class);
    }

    @Override
    public Class<TranslateUpperSaxonGerman> getAnnotationClass() {
        return TranslateUpperSaxonGerman.class;
    }
}
