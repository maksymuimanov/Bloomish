package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.client.language.provider.VietnameseProvider;
import io.bloomish.api.engine.initialization.initializer.StrategyInitializer;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateVietnamese;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyInitializer.DEFAULT_FIELD_DATA)
public class TranslateVietnameseStrategy extends TranslationStrategy<TranslateVietnamese> {
    public TranslateVietnameseStrategy() {
        super(VietnameseProvider.class);
    }

    @Override
    public Class<TranslateVietnamese> getAnnotationClass() {
        return TranslateVietnamese.class;
    }
}
