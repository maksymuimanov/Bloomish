package io.bloomish.api.data.client.model.deprecated.block.strategy;

import io.bloomish.api.data.client.model.deprecated.block.ApiBlockModelProvider;
import io.bloomish.api.data.client.model.deprecated.block.spec.DependantBlockModelSpec;
import net.minecraft.world.level.block.FenceGateBlock;

public class FenceGateBlockModelProviderStrategy implements BlockModelProviderStrategy<DependantBlockModelSpec> {
    @Override
    public void registerBlockModel(DependantBlockModelSpec spec, ApiBlockModelProvider provider) {
        provider.<FenceGateBlock>otherBlockTexture(spec, (block, parentTexture) ->
                provider.fenceGateBlockWithRenderType(block, parentTexture, spec.getRenderType()));
    }
}
