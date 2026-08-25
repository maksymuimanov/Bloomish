package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.client.language.provider.IcelandicProvider;
import io.bloomish.api.engine.initialization.initializer.StrategyInitializer;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateIcelandic;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyInitializer.DEFAULT_FIELD_DATA)
public class TranslateIcelandicStrategy extends TranslationStrategy<TranslateIcelandic> {
    public TranslateIcelandicStrategy() {
        super(IcelandicProvider.class);
    }

    @Override
    public Class<TranslateIcelandic> getAnnotationClass() {
        return TranslateIcelandic.class;
    }
}
