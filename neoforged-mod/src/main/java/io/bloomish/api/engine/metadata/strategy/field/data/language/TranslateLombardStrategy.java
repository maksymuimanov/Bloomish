package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.client.language.provider.LombardProvider;
import io.bloomish.api.engine.initialization.initializer.StrategyInitializer;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateLombard;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyInitializer.DEFAULT_FIELD_DATA)
public class TranslateLombardStrategy extends TranslationStrategy<TranslateLombard> {
    public TranslateLombardStrategy() {
        super(LombardProvider.class);
    }

    @Override
    public Class<TranslateLombard> getAnnotationClass() {
        return TranslateLombard.class;
    }
}
