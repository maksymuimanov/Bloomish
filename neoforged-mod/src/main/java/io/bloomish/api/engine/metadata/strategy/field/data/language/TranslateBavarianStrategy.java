package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.language.provider.BavarianProvider;
import io.bloomish.api.engine.initialization.initializer.StrategyPoolInitializer;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateBavarian;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyPoolInitializer.DEFAULT_FIELD_DATA)
public class TranslateBavarianStrategy extends TranslationStrategy<TranslateBavarian> {
    public TranslateBavarianStrategy() {
        super(BavarianProvider.class);
    }

    @Override
    public Class<TranslateBavarian> getAnnotationClass() {
        return TranslateBavarian.class;
    }
}
