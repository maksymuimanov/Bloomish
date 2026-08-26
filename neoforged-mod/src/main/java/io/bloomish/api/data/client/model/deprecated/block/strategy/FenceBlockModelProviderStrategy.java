package io.bloomish.api.data.client.model.deprecated.block.strategy;

import io.bloomish.api.data.client.model.deprecated.block.ApiBlockModelProvider;
import io.bloomish.api.data.client.model.deprecated.block.spec.DependantBlockModelSpec;
import net.minecraft.world.level.block.FenceBlock;

public class FenceBlockModelProviderStrategy implements BlockModelProviderStrategy<DependantBlockModelSpec> {
    @Override
    public void registerBlockModel(DependantBlockModelSpec spec, ApiBlockModelProvider provider) {
        provider.<FenceBlock>otherBlockTexture(spec, (block, parentTexture) ->
                provider.fenceBlockWithRenderType(block, parentTexture, spec.getRenderType()));
    }
}