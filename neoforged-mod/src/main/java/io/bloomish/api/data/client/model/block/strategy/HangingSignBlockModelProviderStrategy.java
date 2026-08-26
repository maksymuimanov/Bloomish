package io.bloomish.api.data.client.model.block.strategy;

import io.bloomish.api.data.client.model.block.ApiBlockModelProvider;
import io.bloomish.api.data.client.model.block.spec.SignBlockModelSpec;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.CeilingHangingSignBlock;
import net.minecraft.world.level.block.WallHangingSignBlock;

public class HangingSignBlockModelProviderStrategy implements BlockModelProviderStrategy<SignBlockModelSpec> {
    @Override
    public void registerBlockModel(SignBlockModelSpec spec, ApiBlockModelProvider provider) {
        CeilingHangingSignBlock ceilingBlock = spec.getBlock();
        WallHangingSignBlock wallBlock = spec.getDependencyBlock();
        ResourceLocation particleTexture = spec.getParticleTexture();
        provider.hangingSignBlock(ceilingBlock, wallBlock, particleTexture);
    }
}
