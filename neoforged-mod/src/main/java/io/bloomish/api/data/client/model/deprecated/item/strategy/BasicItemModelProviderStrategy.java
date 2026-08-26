package io.bloomish.api.data.client.model.deprecated.item.strategy;

import io.bloomish.api.data.client.model.deprecated.item.ApiItemModelProvider;
import io.bloomish.api.data.client.model.deprecated.item.ItemModelProviderStrategy;
import io.bloomish.api.data.client.model.deprecated.item.spec.ItemModelSpec;
import net.minecraft.world.item.Item;

public class BasicItemModelProviderStrategy implements ItemModelProviderStrategy<ItemModelSpec> {
    @Override
    public void registerItemModel(ItemModelSpec spec, ApiItemModelProvider provider) {
        Item item = spec.getItem();
        provider.basicItem(item);
    }
}
