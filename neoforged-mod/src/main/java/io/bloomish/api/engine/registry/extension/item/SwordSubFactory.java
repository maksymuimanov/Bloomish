package io.bloomish.api.engine.registry.extension.item;

import io.bloomish.api.engine.context.DefaultObjectRegistry;
import io.bloomish.api.engine.registry.factory.ItemFactory;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.neoforged.neoforge.registries.DeferredItem;

public interface SwordSubFactory {
    default DeferredItem<SwordItem> createSword(String name, Tier tier, int damage, float speed) {
        return this.createSword(name, new Item.Properties(), tier, damage, speed);
    }

    default DeferredItem<SwordItem> createSword(String name, Item.Properties properties, Tier tier, int damage, float speed) {
        ItemFactory itemFactory = DefaultObjectRegistry.getFromInstance(ItemFactory.class);
        return itemFactory.create(name, properties.attributes(SwordItem.createAttributes(tier, damage, speed)), props -> new SwordItem(tier, props));
    }
}
