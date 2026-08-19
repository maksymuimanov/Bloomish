package io.bloomish.api.engine.event.data.model.item.strategy;

import io.bloomish.api.engine.event.data.model.ModelConstants;
import io.bloomish.api.engine.event.data.model.item.ApiItemModelProvider;
import io.bloomish.api.engine.event.data.model.item.ItemModelProviderStrategy;
import io.bloomish.api.engine.event.data.model.item.spec.BlockItemModelSpec;
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
