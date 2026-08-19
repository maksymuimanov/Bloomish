package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.language.provider.BashkirProvider;
import io.bloomish.api.engine.initialization.initializer.StrategyPoolInitializer;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateBashkir;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class TranslateBashkirStrategy extends TranslationStrategy<TranslateBashkir> {
    public TranslateBashkirStrategy() {
        super(BashkirProvider.class);
    }

    @Override
    public Class<TranslateBashkir> getAnnotationClass() {
        return TranslateBashkir.class;
    }
}
