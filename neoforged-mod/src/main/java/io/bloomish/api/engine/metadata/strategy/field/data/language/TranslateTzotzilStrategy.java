package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.language.provider.TzotzilProvider;
import io.bloomish.api.engine.initialization.initializer.StrategyInitializer;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateTzotzil;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyInitializer.DEFAULT_FIELD_DATA)
public class TranslateTzotzilStrategy extends TranslationStrategy<TranslateTzotzil> {
    public TranslateTzotzilStrategy() {
        super(TzotzilProvider.class);
    }

    @Override
    public Class<TranslateTzotzil> getAnnotationClass() {
        return TranslateTzotzil.class;
    }
}
