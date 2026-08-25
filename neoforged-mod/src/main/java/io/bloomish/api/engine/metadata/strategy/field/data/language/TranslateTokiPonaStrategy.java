package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.client.language.provider.TokiPonaProvider;
import io.bloomish.api.engine.initialization.initializer.StrategyInitializer;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateTokiPona;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyInitializer.DEFAULT_FIELD_DATA)
public class TranslateTokiPonaStrategy extends TranslationStrategy<TranslateTokiPona> {
    public TranslateTokiPonaStrategy() {
        super(TokiPonaProvider.class);
    }

    @Override
    public Class<TranslateTokiPona> getAnnotationClass() {
        return TranslateTokiPona.class;
    }
}
