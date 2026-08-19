package io.bloomish.api.engine.event.data.model.item.strategy;

import io.bloomish.api.engine.event.data.model.ModelConstants;
import io.bloomish.api.engine.event.data.model.item.ApiItemModelProvider;
import io.bloomish.api.engine.event.data.model.item.ItemModelProviderStrategy;
import io.bloomish.api.engine.event.data.model.item.spec.BlockItemModelSpec;
import net.minecraft.resources.ResourceLocation;

public class BarrelBlockItemModelProviderStrategy implements ItemModelProviderStrategy<BlockItemModelSpec> {
    @Override
    public void registerItemModel(BlockItemModelSpec spec, ApiItemModelProvider provider) {
        String itemPath = spec.getPath();
        ResourceLocation sideTexture = spec.getBlockLocation(ModelConstants.SIDE_SUFFIX);
        ResourceLocation bottomTexture = spec.getBlockLocation(ModelConstants.BOTTOM_SUFFIX);
        ResourceLocation topTexture = spec.getBlockLocation(ModelConstants.TOP_SUFFIX);
        provider.cubeBottomTop(itemPath, sideTexture, bottomTexture, topTexture);
    }
}
