package io.bloomish.api.engine.event.data.model.item.strategy;

import io.bloomish.api.engine.event.data.model.item.ApiItemModelProvider;
import io.bloomish.api.engine.event.data.model.item.ItemModelProviderStrategy;
import io.bloomish.api.engine.event.data.model.item.spec.DependantBlockItemModelSpec;
import net.minecraft.resources.ResourceLocation;

public class WallBlockItemModelProviderStrategy implements ItemModelProviderStrategy<DependantBlockItemModelSpec> {
    @Override
    public void registerItemModel(DependantBlockItemModelSpec spec, ApiItemModelProvider provider) {
        String itemPath = spec.getPath();
        ResourceLocation texture = spec.getDependencyBlockLocation();
        provider.wallInventory(itemPath, texture);
    }
}
