package io.bloomish.api.engine.event.data.client.model.block.strategy;

import io.bloomish.api.engine.event.data.client.model.block.ApiBlockModelProvider;
import io.bloomish.api.engine.event.data.client.model.block.spec.BlockModelSpec;
import io.bloomish.api.util.DeprecatedResourceUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.RotatedPillarBlock;

public class WoodBlockModelProviderStrategy implements BlockModelProviderStrategy<BlockModelSpec> {
    public static final String WOOD = "wood";
    public static final String LOG = "log";

    @Override
    public void registerBlockModel(BlockModelSpec spec, ApiBlockModelProvider provider) {
        RotatedPillarBlock block = spec.getBlock();
        String logBlockPath = spec.getPath().replace(WOOD, LOG);
        ResourceLocation texture = DeprecatedResourceUtils.parse(logBlockPath);
        provider.axisBlockWithRenderType(block, texture, texture, spec.getRenderType());
    }
}
