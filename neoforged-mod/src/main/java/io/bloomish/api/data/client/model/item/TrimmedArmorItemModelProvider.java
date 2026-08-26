package io.bloomish.api.data.client.model.item;

import io.bloomish.api.channel.DataChannels;
import io.bloomish.api.channel.ValueChannelBus;
import io.bloomish.api.data.client.model.item.model.ItemModel;
import io.bloomish.api.data.client.model.item.model.LayeredItemModel;
import io.bloomish.api.data.client.model.item.model.TrimmedArmorItemModel;
import io.bloomish.api.data.client.model.item.spec.ItemModelSpec;
import io.bloomish.api.engine.metadata.annotation.injection.Injected;
import io.bloomish.api.util.MinecraftConstants;
import io.bloomish.api.util.RegistryUtils;
import io.bloomish.api.util.ResourceLocationUtils;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.ArmorItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Injected
public class TrimmedArmorItemModelProvider extends AbstractItemModelProvider {
    private static final String GENERATED_PATH = "generated";
    private static final String[] TRIM_MATERIALS = {"quartz", "iron", "netherite", "redstone", "copper", "gold", "emerald", "diamond", "lapis", "amethyst"};
    private static final String LAYER_0 = "layer0";
    private static final String LAYER_1 = "layer1";
    private static final float TRIM_TYPE_COEFFICIENT = 10F;
    private static final String MINECRAFT_TRIM_TYPE = "minecraft:trim_type";
    private final ValueChannelBus channelBus;

    public TrimmedArmorItemModelProvider(PackOutput packOutput, ValueChannelBus channelBus) {
        super(packOutput);
        this.channelBus = channelBus;
    }

    @Override
    protected void registerData() {
        this.channelBus.<ItemModelSpec<? extends ArmorItem>>forEachDrain(DataChannels.ITEM_MODEL_PROVIDER_TRIMMED_ARMOR_ITEMS, spec -> {
            ArmorItem item = spec.getItem();
            String parent = ResourceLocationUtils.joinNamespacedPath(MinecraftConstants.MINECRAFT, ITEM_PATH, GENERATED_PATH);
            String path = RegistryUtils.findItemNamespacedPath(item, ITEM_PATH);
            List<TrimmedArmorItemModel.Override> overrides = this.createOverrides(path, item, parent);
            Map<String, String> textures = Map.of(LAYER_0, path);
            ItemModel itemModel = new TrimmedArmorItemModel(parent, overrides, textures);
            this.addItemModel(item, itemModel);
        });
    }

    private List<TrimmedArmorItemModel.Override> createOverrides(String path, ArmorItem item, String parent) {
        List<TrimmedArmorItemModel.Override> overrides = new ArrayList<>();
        for (int i = 0; i < TRIM_MATERIALS.length; i++) {
            String trimMaterial = TRIM_MATERIALS[i];
            this.addTrimToOverrides(i, path, overrides, trimMaterial);
            this.createTrimmedArmorItemModel(path, item, trimMaterial, parent);
        }
        return overrides;
    }

    private void addTrimToOverrides(int index, String path, List<TrimmedArmorItemModel.Override> overrides, String trimMaterial) {
        String trimModelPath = path + "_" + trimMaterial + "_trim";
        float trimTypePropertyValue = (index + 1) / TRIM_TYPE_COEFFICIENT;
        Map<String, Float> predicate = Map.of(MINECRAFT_TRIM_TYPE, trimTypePropertyValue);
        TrimmedArmorItemModel.Override override = new TrimmedArmorItemModel.Override(trimModelPath, predicate);
        overrides.add(override);
    }

    private void createTrimmedArmorItemModel(String path, ArmorItem item, String trimMaterial, String parent) {
        Map<String, String> textures = Map.of(
                LAYER_0, path,
                LAYER_1, ResourceLocationUtils.joinNamespacedPath(MinecraftConstants.MINECRAFT, "trims", "items", item.getType().getName() + "_trim_" + trimMaterial)
        );
        ItemModel trimmedArmorItemModel = new LayeredItemModel(parent, textures);
        this.addItemModel(item, trimmedArmorItemModel);
    }
}
