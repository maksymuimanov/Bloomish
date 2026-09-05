package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.client.language.provider.ElfdalianProvider;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateElfdalian;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;
import io.bloomish.api.initialization.initializer.StrategyInitializer;

@Strategy(StrategyInitializer.DEFAULT_FIELD_DATA)
public class TranslateElfdalianStrategy extends TranslationStrategy<TranslateElfdalian> {
    public TranslateElfdalianStrategy() {
        super(ElfdalianProvider.class);
    }

    @Override
    public Class<TranslateElfdalian> getAnnotationClass() {
        return TranslateElfdalian.class;
    }
}
