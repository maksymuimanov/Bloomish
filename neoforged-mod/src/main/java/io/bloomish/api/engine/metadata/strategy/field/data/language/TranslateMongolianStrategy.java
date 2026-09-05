package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.client.language.provider.MongolianProvider;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateMongolian;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;
import io.bloomish.api.initialization.initializer.StrategyInitializer;

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
