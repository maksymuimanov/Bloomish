package io.bloomish.api.data.client.model.item.strategy;

import io.bloomish.api.data.client.model.ModelConstants;
import io.bloomish.api.data.client.model.item.ApiItemModelProvider;
import io.bloomish.api.data.client.model.item.ItemModelProviderStrategy;
import io.bloomish.api.data.client.model.item.spec.ItemModelSpec;
import net.minecraft.resources.ResourceLocation;

public class PotionItemModelProviderStrategy implements ItemModelProviderStrategy<ItemModelSpec> {
    public static final String MODEL_PARENT = "item/potion";
    public static final String LAYER_0_TEXTURE = "item/potion_overlay";

    @Override
    public void registerItemModel(ItemModelSpec spec, ApiItemModelProvider provider) {
        String itemPath = spec.getPath();
        ResourceLocation texture = spec.getLocation();
        provider.withExistingParent(itemPath, MODEL_PARENT)
                .texture(ModelConstants.LAYER_0, provider.mcLoc(LAYER_0_TEXTURE))
                .texture(ModelConstants.LAYER_1, texture);
    }
}
