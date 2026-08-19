package io.bloomish.api.engine.registry.extension.item;

import io.bloomish.api.engine.context.InjectionPool;
import io.bloomish.api.engine.registry.factory.ItemFactory;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Instrument;
import net.minecraft.world.item.InstrumentItem;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;

public interface InstrumentSubFactory {
    default DeferredItem<InstrumentItem> createInstrument(String name, TagKey<Instrument> instruments) {
        return this.createInstrument(name, new Item.Properties(), instruments);
    }

    default DeferredItem<InstrumentItem> createInstrument(String name, Item.Properties properties, TagKey<Instrument> instruments) {
        ItemFactory itemFactory = InjectionPool.getFromInstance(ItemFactory.class);
        return itemFactory.create(name, properties.stacksTo(1), props -> new InstrumentItem(props, instruments));
    }
}
