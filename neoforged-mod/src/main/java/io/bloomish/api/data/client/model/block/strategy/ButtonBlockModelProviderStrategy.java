package io.bloomish.api.data.client.model.block.strategy;

import io.bloomish.api.data.client.model.block.ApiBlockModelProvider;
import io.bloomish.api.data.client.model.block.spec.DependantBlockModelSpec;
import net.minecraft.world.level.block.ButtonBlock;

public class ButtonBlockModelProviderStrategy implements BlockModelProviderStrategy<DependantBlockModelSpec> {
    @Override
    public void registerBlockModel(DependantBlockModelSpec spec, ApiBlockModelProvider provider) {
        provider.<ButtonBlock>otherBlockTexture(spec, provider::buttonBlock);
    }
}
