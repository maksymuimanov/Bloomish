package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.language.provider.LaoProvider;
import io.bloomish.api.engine.initialization.initializer.StrategyPoolInitializer;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateLao;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class TranslateLaoStrategy extends TranslationStrategy<TranslateLao> {
    public TranslateLaoStrategy() {
        super(LaoProvider.class);
    }

    @Override
    public Class<TranslateLao> getAnnotationClass() {
        return TranslateLao.class;
    }
}
