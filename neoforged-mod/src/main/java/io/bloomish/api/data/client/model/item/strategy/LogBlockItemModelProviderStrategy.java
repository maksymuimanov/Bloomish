package io.bloomish.api.data.client.model.item.strategy;

import io.bloomish.api.data.client.model.ModelConstants;
import io.bloomish.api.data.client.model.item.ApiItemModelProvider;
import io.bloomish.api.data.client.model.item.ItemModelProviderStrategy;
import io.bloomish.api.data.client.model.item.spec.BlockItemModelSpec;
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
