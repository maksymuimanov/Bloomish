package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.language.provider.TraditionalTaiwanChineseProvider;
import io.bloomish.api.engine.initialization.initializer.StrategyInitializer;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateTraditionalTaiwanChinese;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyInitializer.DEFAULT_FIELD_DATA)
public class TranslateTraditionalTaiwanChineseStrategy extends TranslationStrategy<TranslateTraditionalTaiwanChinese> {
    public TranslateTraditionalTaiwanChineseStrategy() {
        super(TraditionalTaiwanChineseProvider.class);
    }

    @Override
    public Class<TranslateTraditionalTaiwanChinese> getAnnotationClass() {
        return TranslateTraditionalTaiwanChinese.class;
    }
}
