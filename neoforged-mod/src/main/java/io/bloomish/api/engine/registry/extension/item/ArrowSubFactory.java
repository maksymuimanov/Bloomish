package io.bloomish.api.engine.registry.extension.item;

import io.bloomish.api.engine.context.InjectionPool;
import io.bloomish.api.engine.registry.factory.ItemFactory;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;

public interface ArrowSubFactory {
    default DeferredItem<ArrowItem> createArrow(String name) {
        return this.createArrow(name, new Item.Properties());
    }

    default DeferredItem<ArrowItem> createArrow(String name, Item.Properties properties) {
        ItemFactory itemFactory = InjectionPool.getFromInstance(ItemFactory.class);
        return itemFactory.create(name, properties, ArrowItem::new);
    }
}
