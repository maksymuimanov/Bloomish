package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.language.provider.MongolianProvider;
import io.bloomish.api.engine.initialization.initializer.StrategyInitializer;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateMongolian;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyInitializer.DEFAULT_FIELD_DATA)
public class TranslateMongolianStrategy extends TranslationStrategy<TranslateMongolian> {
    public TranslateMongolianStrategy() {
        super(MongolianProvider.class);
    }

    @Override
    public Class<TranslateMongolian> getAnnotationClass() {
        return TranslateMongolian.class;
    }
}
