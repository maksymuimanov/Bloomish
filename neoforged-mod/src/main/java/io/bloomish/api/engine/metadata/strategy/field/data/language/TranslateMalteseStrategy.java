package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.client.language.provider.MalteseProvider;
import io.bloomish.api.engine.initialization.initializer.StrategyInitializer;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateMaltese;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyInitializer.DEFAULT_FIELD_DATA)
public class TranslateMalteseStrategy extends TranslationStrategy<TranslateMaltese> {
    public TranslateMalteseStrategy() {
        super(MalteseProvider.class);
    }

    @Override
    public Class<TranslateMaltese> getAnnotationClass() {
        return TranslateMaltese.class;
    }
}
