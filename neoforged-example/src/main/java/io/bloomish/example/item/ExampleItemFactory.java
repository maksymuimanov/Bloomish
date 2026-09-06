package io.bloomish.example.item;

import io.bloomish.api.bean.Bean;
import io.bloomish.api.engine.registry.extension.item.*;
import io.bloomish.api.engine.registry.factory.ItemFactory;

@Bean
public final class ExampleItemFactory extends ItemFactory implements SwordSubFactory,
        BowSubFactory,
        CrossbowSubFactory,
        ArmorSubFactory,
        SignSubFactory,
        HangingSignSubFactory,
        BoatSubFactory,
        SpawnEggSubFactory,
        SmithingTemplateSubFactory,
        BannerPatternSubFactory,
        MusicDiscSubFactory,
        InstrumentSubFactory {
}
