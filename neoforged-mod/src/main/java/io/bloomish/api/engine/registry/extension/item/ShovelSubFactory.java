package io.bloomish.api.engine.registry.extension.item;

import io.bloomish.api.engine.context.DefaultObjectRegistry;
import io.bloomish.api.engine.registry.factory.ItemFactory;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.Tier;
import net.neoforged.neoforge.registries.DeferredItem;

public interface ShovelSubFactory {
    default DeferredItem<ShovelItem> createShovel(String name, Tier tier, float damage, float speed) {
        return this.createShovel(name, new Item.Properties(), tier, damage, speed);
    }

    default DeferredItem<ShovelItem> createShovel(String name, Item.Properties properties, Tier tier, float damage, float speed) {
        ItemFactory itemFactory = DefaultObjectRegistry.getFromInstance(ItemFactory.class);
        return itemFactory.create(name, properties.attributes(ShovelItem.createAttributes(tier, damage, speed)), props -> new ShovelItem(tier, props));
    }
}
