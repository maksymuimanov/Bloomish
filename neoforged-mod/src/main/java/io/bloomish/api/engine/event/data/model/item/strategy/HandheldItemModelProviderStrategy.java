package io.bloomish.api.engine.event.data.model.item.strategy;

import io.bloomish.api.engine.event.data.model.item.ApiItemModelProvider;
import io.bloomish.api.engine.event.data.model.item.ItemModelProviderStrategy;
import io.bloomish.api.engine.event.data.model.item.spec.ItemModelSpec;
import net.minecraft.world.item.Item;

public class HandheldItemModelProviderStrategy implements ItemModelProviderStrategy<ItemModelSpec> {
    @Override
    public void registerItemModel(ItemModelSpec spec, ApiItemModelProvider provider) {
        Item item = spec.getItem();
        provider.handheldItem(item);
    }
}
