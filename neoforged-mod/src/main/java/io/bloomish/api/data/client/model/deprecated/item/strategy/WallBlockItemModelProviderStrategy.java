package io.bloomish.api.data.client.model.deprecated.item.strategy;

import io.bloomish.api.data.client.model.deprecated.item.ApiItemModelProvider;
import io.bloomish.api.data.client.model.deprecated.item.ItemModelProviderStrategy;
import io.bloomish.api.data.client.model.deprecated.item.spec.DependantBlockItemModelSpec;
import net.minecraft.resources.ResourceLocation;

public class WallBlockItemModelProviderStrategy implements ItemModelProviderStrategy<DependantBlockItemModelSpec> {
    @Override
    public void registerItemModel(DependantBlockItemModelSpec spec, ApiItemModelProvider provider) {
        String itemPath = spec.getPath();
        ResourceLocation texture = spec.getDependencyBlockLocation();
        provider.wallInventory(itemPath, texture);
    }
}
