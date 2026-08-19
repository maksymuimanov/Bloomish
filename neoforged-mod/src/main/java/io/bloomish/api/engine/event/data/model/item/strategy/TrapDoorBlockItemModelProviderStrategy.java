package io.bloomish.api.engine.event.data.model.item.strategy;

import io.bloomish.api.engine.event.data.model.item.ApiItemModelProvider;
import io.bloomish.api.engine.event.data.model.item.ItemModelProviderStrategy;
import io.bloomish.api.engine.event.data.model.item.spec.TrapDoorBlockItemModelSpec;
import net.minecraft.resources.ResourceLocation;

public class TrapDoorBlockItemModelProviderStrategy implements ItemModelProviderStrategy<TrapDoorBlockItemModelSpec> {
    @Override
    public void registerItemModel(TrapDoorBlockItemModelSpec spec, ApiItemModelProvider provider) {
        String itemPath = spec.getPath();
        ResourceLocation texture = spec.getBlockLocation();
        if (spec.isOrientable()) {
            provider.trapdoorOrientableBottom(itemPath, texture);
        } else {
            provider.trapdoorBottom(itemPath, texture);
        }
    }
}
