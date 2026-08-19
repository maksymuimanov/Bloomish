package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.language.provider.TokiPonaProvider;
import io.bloomish.api.engine.initialization.initializer.StrategyPoolInitializer;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateTokiPona;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class TranslateTokiPonaStrategy extends TranslationStrategy<TranslateTokiPona> {
    public TranslateTokiPonaStrategy() {
        super(TokiPonaProvider.class);
    }

    @Override
    public Class<TranslateTokiPona> getAnnotationClass() {
        return TranslateTokiPona.class;
    }
}
