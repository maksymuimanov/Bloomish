package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.client.language.provider.BavarianProvider;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateBavarian;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;
import io.bloomish.api.initialization.initializer.StrategyInitializer;

@Strategy(StrategyInitializer.DEFAULT_FIELD_DATA)
public class TranslateBavarianStrategy extends TranslationStrategy<TranslateBavarian> {
    public TranslateBavarianStrategy() {
        super(BavarianProvider.class);
    }

    @Override
    public Class<TranslateBavarian> getAnnotationClass() {
        return TranslateBavarian.class;
    }
}
