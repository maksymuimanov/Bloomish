package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.client.language.provider.TraditionalTaiwanChineseProvider;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateTraditionalTaiwanChinese;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;
import io.bloomish.api.initialization.initializer.StrategyInitializer;

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
