package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.language.provider.LolcatProvider;
import io.bloomish.api.engine.initialization.initializer.StrategyPoolInitializer;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateLolcat;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class TranslateLolcatStrategy extends TranslationStrategy<TranslateLolcat> {
    public TranslateLolcatStrategy() {
        super(LolcatProvider.class);
    }

    @Override
    public Class<TranslateLolcat> getAnnotationClass() {
        return TranslateLolcat.class;
    }
}
