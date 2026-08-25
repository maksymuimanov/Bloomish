package io.bloomish.api.engine.event.data.client.model.item.strategy;

import io.bloomish.api.engine.event.data.client.model.ModelConstants;
import io.bloomish.api.engine.event.data.client.model.item.ApiItemModelProvider;
import io.bloomish.api.engine.event.data.client.model.item.ItemModelProviderStrategy;
import io.bloomish.api.engine.event.data.client.model.item.spec.ItemModelSpec;
import io.bloomish.api.util.DeprecatedResourceUtils;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.world.item.ArmorItem;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ModelFile;

public class TrimmedItemModelProviderStrategy implements ItemModelProviderStrategy<ItemModelSpec> {
    private static final String[] TRIM_MATERIALS = {"quartz", "iron", "netherite", "redstone", "copper", "gold", "emerald", "diamond", "lapis", "amethyst"};
    public static final String TRIM_TYPE_PROPERTY = "trim_type";

    @Override
    public void registerItemModel(ItemModelSpec spec, ApiItemModelProvider provider) {
        ArmorItem item = spec.getItem();
        String itemPath = spec.getPath();
        ResourceLocation location = BuiltInRegistries.ITEM.getKey(item);
        ItemModelBuilder itemModel = provider.simpleItem(itemPath, ModelConstants.GENERATED);
        int trimType = 1;
        for (String trim : TRIM_MATERIALS) {
            ResourceLocation name = ResourceLocation.fromNamespaceAndPath(location.getNamespace(), ItemModelSpec.ITEM_PREFIX + "/" + location.getPath() + "_" + trim + "_trim");
            float trimTypePropertyValue = trimType / 10f;
            itemModel.override()
                    .model(new ModelFile.UncheckedModelFile(name))
                    .predicate(ResourceLocation.withDefaultNamespace(TRIM_TYPE_PROPERTY), trimTypePropertyValue);
            String armorTypeName = item.getType().getName();
            ResourceLocation texture = ResourceLocation.withDefaultNamespace("trims/items/" + armorTypeName + "_trim_" + trim);
            provider.existingFileHelper.trackGenerated(texture, PackType.CLIENT_RESOURCES, ".png", "textures");
            provider.withExistingParent(name.getPath(), ModelConstants.ITEM_GENERATED)
                    .texture(ModelConstants.LAYER_0, DeprecatedResourceUtils.parse(ItemModelSpec.ITEM_PREFIX + "/" + location.getPath()))
                    .texture(ModelConstants.LAYER_1, texture);
            trimType++;
        }
    }
}
