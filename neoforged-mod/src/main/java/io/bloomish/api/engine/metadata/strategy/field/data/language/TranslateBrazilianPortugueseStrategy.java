package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.language.provider.BrazilianPortugueseProvider;
import io.bloomish.api.engine.initialization.initializer.StrategyPoolInitializer;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateBrazilianPortuguese;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class TranslateBrazilianPortugueseStrategy extends TranslationStrategy<TranslateBrazilianPortuguese> {
    public TranslateBrazilianPortugueseStrategy() {
        super(BrazilianPortugueseProvider.class);
    }

    @Override
    public Class<TranslateBrazilianPortuguese> getAnnotationClass() {
        return TranslateBrazilianPortuguese.class;
    }
}
