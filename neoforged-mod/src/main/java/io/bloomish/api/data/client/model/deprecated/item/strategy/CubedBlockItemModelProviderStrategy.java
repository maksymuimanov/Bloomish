package io.bloomish.api.data.client.model.deprecated.item.strategy;

import io.bloomish.api.data.client.model.deprecated.item.ApiItemModelProvider;
import io.bloomish.api.data.client.model.deprecated.item.ItemModelProviderStrategy;
import io.bloomish.api.data.client.model.deprecated.item.spec.BlockItemModelSpec;
import net.minecraft.resources.ResourceLocation;

public class CubedBlockItemModelProviderStrategy implements ItemModelProviderStrategy<BlockItemModelSpec> {
    @Override
    public void registerItemModel(BlockItemModelSpec spec, ApiItemModelProvider provider) {
        String itemPath = spec.getPath();
        ResourceLocation texture = spec.getBlockLocation();
        provider.cubeAll(itemPath, texture);
    }
}
