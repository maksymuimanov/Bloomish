package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.client.language.provider.FilipinoProvider;
import io.bloomish.api.engine.initialization.initializer.StrategyInitializer;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateFilipino;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyInitializer.DEFAULT_FIELD_DATA)
public class TranslateFilipinoStrategy extends TranslationStrategy<TranslateFilipino> {
    public TranslateFilipinoStrategy() {
        super(FilipinoProvider.class);
    }

    @Override
    public Class<TranslateFilipino> getAnnotationClass() {
        return TranslateFilipino.class;
    }
}
