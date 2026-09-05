package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.client.language.provider.TatarProvider;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateTatar;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;
import io.bloomish.api.initialization.initializer.StrategyInitializer;

@Strategy(StrategyInitializer.DEFAULT_FIELD_DATA)
public class TranslateTatarStrategy extends TranslationStrategy<TranslateTatar> {
    public TranslateTatarStrategy() {
        super(TatarProvider.class);
    }

    @Override
    public Class<TranslateTatar> getAnnotationClass() {
        return TranslateTatar.class;
    }
}
