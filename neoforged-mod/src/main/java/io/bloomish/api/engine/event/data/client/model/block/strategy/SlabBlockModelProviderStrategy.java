package io.bloomish.api.engine.event.data.client.model.block.strategy;

import io.bloomish.api.engine.event.data.client.model.block.ApiBlockModelProvider;
import io.bloomish.api.engine.event.data.client.model.block.spec.DependantBlockModelSpec;
import net.minecraft.world.level.block.SlabBlock;

public class SlabBlockModelProviderStrategy implements BlockModelProviderStrategy<DependantBlockModelSpec> {
    @Override
    public void registerBlockModel(DependantBlockModelSpec spec, ApiBlockModelProvider provider) {
        provider.<SlabBlock>otherBlockTexture(spec, (block, parentTexture) ->
                provider.slabBlock(block, parentTexture, parentTexture));
    }
}
