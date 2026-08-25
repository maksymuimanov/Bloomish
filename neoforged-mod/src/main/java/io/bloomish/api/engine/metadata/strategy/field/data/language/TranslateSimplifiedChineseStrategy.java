package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.client.language.provider.SimplifiedChineseProvider;
import io.bloomish.api.engine.initialization.initializer.StrategyInitializer;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateSimplifiedChinese;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyInitializer.DEFAULT_FIELD_DATA)
public class TranslateSimplifiedChineseStrategy extends TranslationStrategy<TranslateSimplifiedChinese> {
    public TranslateSimplifiedChineseStrategy() {
        super(SimplifiedChineseProvider.class);
    }

    @Override
    public Class<TranslateSimplifiedChinese> getAnnotationClass() {
        return TranslateSimplifiedChinese.class;
    }
}
