package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.client.language.provider.FaroeseProvider;
import io.bloomish.api.engine.initialization.initializer.StrategyInitializer;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateFaroese;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyInitializer.DEFAULT_FIELD_DATA)
public class TranslateFaroeseStrategy extends TranslationStrategy<TranslateFaroese> {
    public TranslateFaroeseStrategy() {
        super(FaroeseProvider.class);
    }

    @Override
    public Class<TranslateFaroese> getAnnotationClass() {
        return TranslateFaroese.class;
    }
}
