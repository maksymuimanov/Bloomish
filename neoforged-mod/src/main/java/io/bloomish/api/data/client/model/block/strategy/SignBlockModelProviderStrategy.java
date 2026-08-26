package io.bloomish.api.data.client.model.block.strategy;

import io.bloomish.api.data.client.model.block.ApiBlockModelProvider;
import io.bloomish.api.data.client.model.block.spec.SignBlockModelSpec;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.StandingSignBlock;
import net.minecraft.world.level.block.WallSignBlock;

public class SignBlockModelProviderStrategy implements BlockModelProviderStrategy<SignBlockModelSpec> {
    @Override
    public void registerBlockModel(SignBlockModelSpec spec, ApiBlockModelProvider provider) {
        StandingSignBlock standingBlock = spec.getBlock();
        WallSignBlock wallBlock = spec.getDependencyBlock();
        ResourceLocation particleTexture = spec.getParticleTexture();
        provider.signBlock(standingBlock, wallBlock, particleTexture);
    }
}
