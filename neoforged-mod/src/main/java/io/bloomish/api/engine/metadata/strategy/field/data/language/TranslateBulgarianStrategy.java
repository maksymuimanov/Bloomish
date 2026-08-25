package io.bloomish.api.engine.metadata.strategy.field.data.language;

import io.bloomish.api.engine.event.data.client.language.provider.BulgarianProvider;
import io.bloomish.api.engine.initialization.initializer.StrategyInitializer;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateBulgarian;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;

@Strategy(StrategyInitializer.DEFAULT_FIELD_DATA)
public class TranslateBulgarianStrategy extends TranslationStrategy<TranslateBulgarian> {
    public TranslateBulgarianStrategy() {
        super(BulgarianProvider.class);
    }

    @Override
    public Class<TranslateBulgarian> getAnnotationClass() {
        return TranslateBulgarian.class;
    }
}
