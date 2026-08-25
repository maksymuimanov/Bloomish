package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.client.language.provider.LaoProvider;
import io.bloomish.api.engine.initialization.initializer.StrategyInitializer;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateLao;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyInitializer.DEFAULT_FIELD_DATA)
public class TranslateLaoStrategy extends TranslationStrategy<TranslateLao> {
    public TranslateLaoStrategy() {
        super(LaoProvider.class);
    }

    @Override
    public Class<TranslateLao> getAnnotationClass() {
        return TranslateLao.class;
    }
}
