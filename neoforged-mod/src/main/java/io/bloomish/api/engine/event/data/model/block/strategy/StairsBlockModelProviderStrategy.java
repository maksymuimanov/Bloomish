package io.bloomish.api.engine.event.data.model.block.strategy;

import io.bloomish.api.engine.event.data.model.block.ApiBlockModelProvider;
import io.bloomish.api.engine.event.data.model.block.spec.DependantBlockModelSpec;
import net.minecraft.world.level.block.StairBlock;

public class StairsBlockModelProviderStrategy implements BlockModelProviderStrategy<DependantBlockModelSpec> {
    @Override
    public void registerBlockModel(DependantBlockModelSpec spec, ApiBlockModelProvider provider) {
        provider.<StairBlock>otherBlockTexture(spec, provider::stairsBlock);
    }
}
