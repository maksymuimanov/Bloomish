package io.bloomish.api.data.client.model.deprecated.item.strategy;

import io.bloomish.api.data.client.model.deprecated.item.ApiItemModelProvider;
import io.bloomish.api.data.client.model.deprecated.item.ItemModelProviderStrategy;
import io.bloomish.api.data.client.model.deprecated.item.spec.TrapDoorBlockItemModelSpec;
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
