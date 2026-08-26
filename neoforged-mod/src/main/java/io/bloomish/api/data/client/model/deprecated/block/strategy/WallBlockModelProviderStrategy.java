package io.bloomish.api.data.client.model.deprecated.block.strategy;

import io.bloomish.api.data.client.model.deprecated.block.ApiBlockModelProvider;
import io.bloomish.api.data.client.model.deprecated.block.spec.DependantBlockModelSpec;
import net.minecraft.world.level.block.WallBlock;

public class WallBlockModelProviderStrategy implements BlockModelProviderStrategy<DependantBlockModelSpec> {
    @Override
    public void registerBlockModel(DependantBlockModelSpec spec, ApiBlockModelProvider provider) {
        provider.<WallBlock>otherBlockTexture(spec, (block, parentTexture) ->
                provider.wallBlockWithRenderType(block, parentTexture, spec.getRenderType()));
    }
}
