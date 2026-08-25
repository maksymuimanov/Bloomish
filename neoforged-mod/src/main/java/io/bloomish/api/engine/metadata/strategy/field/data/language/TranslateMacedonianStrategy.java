package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.client.language.provider.MacedonianProvider;
import io.bloomish.api.engine.initialization.initializer.StrategyInitializer;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateMacedonian;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyInitializer.DEFAULT_FIELD_DATA)
public class TranslateMacedonianStrategy extends TranslationStrategy<TranslateMacedonian> {
    public TranslateMacedonianStrategy() {
        super(MacedonianProvider.class);
    }

    @Override
    public Class<TranslateMacedonian> getAnnotationClass() {
        return TranslateMacedonian.class;
    }
}
