package io.bloomish.api.data.client.model.deprecated.block.strategy;

import io.bloomish.api.data.client.model.deprecated.ModelConstants;
import io.bloomish.api.data.client.model.deprecated.block.ApiBlockModelProvider;
import io.bloomish.api.data.client.model.deprecated.block.spec.BlockModelSpec;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.RotatedPillarBlock;

public class LogBlockModelProviderStrategy implements BlockModelProviderStrategy<BlockModelSpec> {
    @Override
    public void registerBlockModel(BlockModelSpec spec, ApiBlockModelProvider provider) {
        RotatedPillarBlock block = spec.getBlock();
        ResourceLocation sideTexture = spec.getLocation();
        ResourceLocation endTexture = spec.getLocation(ModelConstants.TOP_SUFFIX);
        provider.axisBlockWithRenderType(block, sideTexture, endTexture, spec.getRenderType());
    }
}