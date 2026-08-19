package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.language.provider.TraditionalHongKongChineseProvider;
import io.bloomish.api.engine.initialization.initializer.StrategyInitializer;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateTraditionalHongKongChinese;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyInitializer.DEFAULT_FIELD_DATA)
public class TranslateTraditionalHongKongChineseStrategy extends TranslationStrategy<TranslateTraditionalHongKongChinese> {
    public TranslateTraditionalHongKongChineseStrategy() {
        super(TraditionalHongKongChineseProvider.class);
    }

    @Override
    public Class<TranslateTraditionalHongKongChinese> getAnnotationClass() {
        return TranslateTraditionalHongKongChinese.class;
    }
}
