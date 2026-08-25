package io.bloomish.api.engine.event.data.client.model.item.strategy;

import io.bloomish.api.engine.event.data.client.model.item.ApiItemModelProvider;
import io.bloomish.api.engine.event.data.client.model.item.ItemModelProviderStrategy;
import io.bloomish.api.engine.event.data.client.model.item.spec.DependantBlockItemModelSpec;
import net.minecraft.resources.ResourceLocation;

public class PressurePlateBlockItemModelProviderStrategy implements ItemModelProviderStrategy<DependantBlockItemModelSpec> {
    @Override
    public void registerItemModel(DependantBlockItemModelSpec spec, ApiItemModelProvider provider) {
        String itemPath = spec.getPath();
        ResourceLocation texture = spec.getDependencyBlockLocation();
        provider.pressurePlate(itemPath, texture);
    }
}
