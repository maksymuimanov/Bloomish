package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.language.provider.LiteraryChineseProvider;
import io.bloomish.api.engine.initialization.initializer.StrategyPoolInitializer;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateLiteraryChinese;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class TranslateLiteraryChineseStrategy extends TranslationStrategy<TranslateLiteraryChinese> {
    public TranslateLiteraryChineseStrategy() {
        super(LiteraryChineseProvider.class);
    }

    @Override
    public Class<TranslateLiteraryChinese> getAnnotationClass() {
        return TranslateLiteraryChinese.class;
    }
}
