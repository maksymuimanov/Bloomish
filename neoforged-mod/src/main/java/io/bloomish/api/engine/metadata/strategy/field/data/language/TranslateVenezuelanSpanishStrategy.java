package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.language.provider.VenezuelanSpanishProvider;
import io.bloomish.api.engine.initialization.initializer.StrategyPoolInitializer;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateVenezuelanSpanish;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class TranslateVenezuelanSpanishStrategy extends TranslationStrategy<TranslateVenezuelanSpanish> {
    public TranslateVenezuelanSpanishStrategy() {
        super(VenezuelanSpanishProvider.class);
    }

    @Override
    public Class<TranslateVenezuelanSpanish> getAnnotationClass() {
        return TranslateVenezuelanSpanish.class;
    }
}
