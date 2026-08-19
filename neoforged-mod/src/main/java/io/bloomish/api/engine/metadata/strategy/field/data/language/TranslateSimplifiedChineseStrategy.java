package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.language.provider.SimplifiedChineseProvider;
import io.bloomish.api.engine.initialization.initializer.StrategyPoolInitializer;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateSimplifiedChinese;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class TranslateSimplifiedChineseStrategy extends TranslationStrategy<TranslateSimplifiedChinese> {
    public TranslateSimplifiedChineseStrategy() {
        super(SimplifiedChineseProvider.class);
    }

    @Override
    public Class<TranslateSimplifiedChinese> getAnnotationClass() {
        return TranslateSimplifiedChinese.class;
    }
}
