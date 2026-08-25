package io.bloomish.api.engine.event.data.client.model.item.strategy;

import io.bloomish.api.engine.event.data.client.model.item.ApiItemModelProvider;
import io.bloomish.api.engine.event.data.client.model.item.ItemModelProviderStrategy;
import io.bloomish.api.engine.event.data.client.model.item.spec.BlockItemModelSpec;
import io.bloomish.api.util.ResourceUtils;
import net.minecraft.resources.ResourceLocation;

public class WoodBlockItemModelProviderStrategy implements ItemModelProviderStrategy<BlockItemModelSpec> {
    public static final String WOOD = "wood";
    public static final String LOG = "log";

    @Override
    public void registerItemModel(BlockItemModelSpec spec, ApiItemModelProvider provider) {
        String itemPath = spec.getPath();
        String blockPath = spec.getBlockPath().replace(WOOD, LOG);
        ResourceLocation texture = ResourceUtils.parse(blockPath);
        provider.cubeColumn(itemPath, texture, texture);
    }
}
