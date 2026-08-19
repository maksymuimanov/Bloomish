package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.language.provider.FriulianProvider;
import io.bloomish.api.engine.initialization.initializer.StrategyInitializer;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateFriulian;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyInitializer.DEFAULT_FIELD_DATA)
public class TranslateFriulianStrategy extends TranslationStrategy<TranslateFriulian> {
    public TranslateFriulianStrategy() {
        super(FriulianProvider.class);
    }

    @Override
    public Class<TranslateFriulian> getAnnotationClass() {
        return TranslateFriulian.class;
    }
}
