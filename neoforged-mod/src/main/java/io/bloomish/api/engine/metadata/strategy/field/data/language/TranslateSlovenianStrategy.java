package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.language.provider.SlovenianProvider;
import io.bloomish.api.engine.initialization.initializer.StrategyInitializer;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateSlovenian;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyInitializer.DEFAULT_FIELD_DATA)
public class TranslateSlovenianStrategy extends TranslationStrategy<TranslateSlovenian> {
    public TranslateSlovenianStrategy() {
        super(SlovenianProvider.class);
    }

    @Override
    public Class<TranslateSlovenian> getAnnotationClass() {
        return TranslateSlovenian.class;
    }
}
