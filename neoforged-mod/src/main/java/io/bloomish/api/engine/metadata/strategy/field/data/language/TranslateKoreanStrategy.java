package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.client.language.provider.KoreanProvider;
import io.bloomish.api.engine.initialization.initializer.StrategyInitializer;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateKorean;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyInitializer.DEFAULT_FIELD_DATA)
public class TranslateKoreanStrategy extends TranslationStrategy<TranslateKorean> {
    public TranslateKoreanStrategy() {
        super(KoreanProvider.class);
    }

    @Override
    public Class<TranslateKorean> getAnnotationClass() {
        return TranslateKorean.class;
    }
}
