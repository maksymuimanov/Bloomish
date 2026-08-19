package io.bloomish.api.engine.registry.extension.item;

import io.bloomish.api.engine.context.DefaultObjectRegistry;
import io.bloomish.api.engine.registry.factory.ItemFactory;
import io.bloomish.api.util.ResourceUtils;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SmithingTemplateItem;
import net.neoforged.neoforge.registries.DeferredItem;

public interface SmithingTemplateSubFactory {
    default DeferredItem<SmithingTemplateItem> createSmithingTemplate(String name, String patternName) {
        return this.createSmithingTemplate(name, new Item.Properties(), patternName);
    }

    default DeferredItem<SmithingTemplateItem> createSmithingTemplate(String name, Item.Properties properties, String patternName) {
        ItemFactory itemFactory = DefaultObjectRegistry.getFromInstance(ItemFactory.class);
        return itemFactory.create(name, properties, (props) -> SmithingTemplateItem.createArmorTrimTemplate(ResourceUtils.parse(patternName)));
    }
}
