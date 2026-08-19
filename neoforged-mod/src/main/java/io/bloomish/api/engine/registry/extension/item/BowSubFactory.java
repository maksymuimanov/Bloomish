package io.bloomish.api.engine.registry.extension.item;

import io.bloomish.api.engine.context.InjectionPool;
import io.bloomish.api.engine.registry.factory.ItemFactory;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;

public interface BowSubFactory {
    default DeferredItem<BowItem> createBow(String name) {
        return this.createBow(name, new Item.Properties());
    }

    default DeferredItem<BowItem> createBow(String name, Item.Properties properties) {
        ItemFactory itemFactory = InjectionPool.getFromInstance(ItemFactory.class);
        return itemFactory.create(name, properties.stacksTo(1), BowItem::new);
    }
}
