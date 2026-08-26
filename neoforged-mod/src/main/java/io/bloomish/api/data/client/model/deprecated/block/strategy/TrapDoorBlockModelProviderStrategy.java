package io.bloomish.api.data.client.model.deprecated.block.strategy;

import io.bloomish.api.data.client.model.deprecated.block.ApiBlockModelProvider;
import io.bloomish.api.data.client.model.deprecated.block.spec.TrapDoorBlockModelSpec;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.TrapDoorBlock;

public class TrapDoorBlockModelProviderStrategy implements BlockModelProviderStrategy<TrapDoorBlockModelSpec> {
    @Override
    public void registerBlockModel(TrapDoorBlockModelSpec spec, ApiBlockModelProvider provider) {
        TrapDoorBlock block = spec.getBlock();
        ResourceLocation texture = spec.getLocation();
        provider.trapdoorBlockWithRenderType(block, texture, spec.isOrientable(), spec.getRenderType());
    }
}
