package io.bloomish.api.data.client.model.deprecated.item.strategy;

import io.bloomish.api.data.client.model.deprecated.item.ApiItemModelProvider;
import io.bloomish.api.data.client.model.deprecated.item.ItemModelProviderStrategy;
import io.bloomish.api.data.client.model.deprecated.item.spec.ItemModelSpec;
import net.minecraft.resources.ResourceLocation;

public class SpawnEggItemModelProviderStrategy implements ItemModelProviderStrategy<ItemModelSpec> {
    @Override
    public void registerItemModel(ItemModelSpec spec, ApiItemModelProvider provider) {
        ResourceLocation texture = spec.getLocation();
        provider.spawnEggItem(texture);
    }
}
