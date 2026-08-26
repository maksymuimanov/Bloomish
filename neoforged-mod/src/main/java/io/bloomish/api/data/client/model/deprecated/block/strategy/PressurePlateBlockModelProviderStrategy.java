package io.bloomish.api.data.client.model.deprecated.block.strategy;

import io.bloomish.api.data.client.model.deprecated.block.ApiBlockModelProvider;
import io.bloomish.api.data.client.model.deprecated.block.spec.DependantBlockModelSpec;
import net.minecraft.world.level.block.PressurePlateBlock;

public class PressurePlateBlockModelProviderStrategy implements BlockModelProviderStrategy<DependantBlockModelSpec> {
    @Override
    public void registerBlockModel(DependantBlockModelSpec spec, ApiBlockModelProvider provider) {
        provider.<PressurePlateBlock>otherBlockTexture(spec, provider::pressurePlateBlock);
    }
}
