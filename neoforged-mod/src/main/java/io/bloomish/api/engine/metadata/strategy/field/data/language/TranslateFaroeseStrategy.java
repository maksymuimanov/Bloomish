package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.language.provider.FaroeseProvider;
import io.bloomish.api.engine.initialization.initializer.StrategyPoolInitializer;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateFaroese;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class TranslateFaroeseStrategy extends TranslationStrategy<TranslateFaroese> {
    public TranslateFaroeseStrategy() {
        super(FaroeseProvider.class);
    }

    @Override
    public Class<TranslateFaroese> getAnnotationClass() {
        return TranslateFaroese.class;
    }
}
