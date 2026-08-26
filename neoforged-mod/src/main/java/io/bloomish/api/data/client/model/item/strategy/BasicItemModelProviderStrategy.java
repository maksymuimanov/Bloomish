package io.bloomish.api.data.client.model.item.strategy;

import io.bloomish.api.data.client.model.item.ApiItemModelProvider;
import io.bloomish.api.data.client.model.item.ItemModelProviderStrategy;
import io.bloomish.api.data.client.model.item.spec.ItemModelSpec;
import net.minecraft.world.item.Item;

public class BasicItemModelProviderStrategy implements ItemModelProviderStrategy<ItemModelSpec> {
    @Override
    public void registerItemModel(ItemModelSpec spec, ApiItemModelProvider provider) {
        Item item = spec.getItem();
        provider.basicItem(item);
    }
}
