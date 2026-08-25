package io.bloomish.api.engine.event.data.client.model.block.strategy;

import io.bloomish.api.engine.event.data.client.model.block.ApiBlockModelProvider;
import io.bloomish.api.engine.event.data.client.model.block.spec.TrapDoorBlockModelSpec;
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
