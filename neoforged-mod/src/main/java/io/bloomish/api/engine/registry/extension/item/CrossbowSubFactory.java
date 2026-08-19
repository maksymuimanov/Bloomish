package io.bloomish.api.engine.registry.extension.item;

import io.bloomish.api.engine.context.DefaultObjectRegistry;
import io.bloomish.api.engine.registry.factory.ItemFactory;
import net.minecraft.world.item.CrossbowItem;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;

public interface CrossbowSubFactory {
    default DeferredItem<CrossbowItem> createCrossbow(String name) {
        return this.createCrossbow(name, new Item.Properties());
    }

    default DeferredItem<CrossbowItem> createCrossbow(String name, Item.Properties properties) {
        ItemFactory itemFactory = DefaultObjectRegistry.getFromInstance(ItemFactory.class);
        return itemFactory.create(name, properties.stacksTo(1), CrossbowItem::new);
    }
}
