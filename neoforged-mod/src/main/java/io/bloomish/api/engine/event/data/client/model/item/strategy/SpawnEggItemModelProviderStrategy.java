package io.bloomish.api.engine.event.data.client.model.item.strategy;

import io.bloomish.api.engine.event.data.client.model.item.ApiItemModelProvider;
import io.bloomish.api.engine.event.data.client.model.item.ItemModelProviderStrategy;
import io.bloomish.api.engine.event.data.client.model.item.spec.ItemModelSpec;
import net.minecraft.resources.ResourceLocation;

public class SpawnEggItemModelProviderStrategy implements ItemModelProviderStrategy<ItemModelSpec> {
    @Override
    public void registerItemModel(ItemModelSpec spec, ApiItemModelProvider provider) {
        ResourceLocation texture = spec.getLocation();
        provider.spawnEggItem(texture);
    }
}
