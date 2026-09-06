package io.bloomish.example.item;

import io.bloomish.api.bean.Injected;
import io.bloomish.api.engine.registry.extension.item.*;
import io.bloomish.api.engine.registry.factory.ItemFactory;

@Injected
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
