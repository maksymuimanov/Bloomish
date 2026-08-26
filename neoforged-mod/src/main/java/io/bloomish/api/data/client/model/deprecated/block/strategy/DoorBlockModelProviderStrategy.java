package io.bloomish.api.data.client.model.deprecated.block.strategy;

import io.bloomish.api.data.client.model.deprecated.ModelConstants;
import io.bloomish.api.data.client.model.deprecated.block.ApiBlockModelProvider;
import io.bloomish.api.data.client.model.deprecated.block.spec.BlockModelSpec;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.DoorBlock;

public class DoorBlockModelProviderStrategy implements BlockModelProviderStrategy<BlockModelSpec> {
    @Override
    public void registerBlockModel(BlockModelSpec spec, ApiBlockModelProvider provider) {
        DoorBlock block = spec.getBlock();
        ResourceLocation bottomTexture = spec.getLocation(ModelConstants.BOTTOM_SUFFIX);
        ResourceLocation topTexture = spec.getLocation(ModelConstants.TOP_SUFFIX);
        provider.doorBlockWithRenderType(block, bottomTexture, topTexture, spec.getRenderType());
    }
}
