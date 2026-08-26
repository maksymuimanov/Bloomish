package io.bloomish.api.data.client.model.deprecated.item.strategy;

import io.bloomish.api.data.client.model.deprecated.ModelConstants;
import io.bloomish.api.data.client.model.deprecated.item.ApiItemModelProvider;
import io.bloomish.api.data.client.model.deprecated.item.ItemModelProviderStrategy;
import io.bloomish.api.data.client.model.deprecated.item.spec.BlockItemModelSpec;
import net.minecraft.resources.ResourceLocation;

public class LogBlockItemModelProviderStrategy implements ItemModelProviderStrategy<BlockItemModelSpec> {
    @Override
    public void registerItemModel(BlockItemModelSpec spec, ApiItemModelProvider provider) {
        String itemPath = spec.getPath();
        ResourceLocation sideTexture = spec.getBlockLocation();
        ResourceLocation endTexture = spec.getBlockLocation(ModelConstants.TOP_SUFFIX);
        provider.cubeColumn(itemPath, sideTexture, endTexture);
    }
}
