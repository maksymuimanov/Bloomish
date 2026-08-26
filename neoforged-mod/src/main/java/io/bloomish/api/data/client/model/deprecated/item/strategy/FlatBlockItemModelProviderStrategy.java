package io.bloomish.api.data.client.model.deprecated.item.strategy;

import io.bloomish.api.data.client.model.deprecated.ModelConstants;
import io.bloomish.api.data.client.model.deprecated.item.ApiItemModelProvider;
import io.bloomish.api.data.client.model.deprecated.item.ItemModelProviderStrategy;
import io.bloomish.api.data.client.model.deprecated.item.spec.BlockItemModelSpec;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.client.model.generators.ModelFile;

public class FlatBlockItemModelProviderStrategy implements ItemModelProviderStrategy<BlockItemModelSpec> {
    @Override
    public void registerItemModel(BlockItemModelSpec spec, ApiItemModelProvider provider) {
        String itemPath = spec.getPath();
        ResourceLocation texture = spec.getBlockLocation();
        provider.getBuilder(itemPath)
                .parent(new ModelFile.UncheckedModelFile(ModelConstants.ITEM_GENERATED))
                .texture(ModelConstants.LAYER_0, texture);
    }
}
