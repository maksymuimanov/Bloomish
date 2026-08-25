package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.client.language.provider.KannadaProvider;
import io.bloomish.api.engine.initialization.initializer.StrategyInitializer;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateKannada;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyInitializer.DEFAULT_FIELD_DATA)
public class TranslateKannadaStrategy extends TranslationStrategy<TranslateKannada> {
    public TranslateKannadaStrategy() {
        super(KannadaProvider.class);
    }

    @Override
    public Class<TranslateKannada> getAnnotationClass() {
        return TranslateKannada.class;
    }
}
