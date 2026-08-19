package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.language.provider.TatarProvider;
import io.bloomish.api.engine.initialization.initializer.StrategyPoolInitializer;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateTatar;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class TranslateTatarStrategy extends TranslationStrategy<TranslateTatar> {
    public TranslateTatarStrategy() {
        super(TatarProvider.class);
    }

    @Override
    public Class<TranslateTatar> getAnnotationClass() {
        return TranslateTatar.class;
    }
}
