package io.bloomish.api.data.client.model.item;

import io.bloomish.api.channel.DataChannels;
import io.bloomish.api.channel.ValueChannelBus;
import io.bloomish.api.data.client.model.item.model.BasicItemModel;
import io.bloomish.api.data.client.model.item.model.ItemModel;
import io.bloomish.api.data.client.model.item.spec.ItemModelSpec;
import io.bloomish.api.engine.metadata.annotation.injection.Injected;
import io.bloomish.api.util.RegistryUtils;
import io.bloomish.api.util.ResourceLocationUtils;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.ArmorItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Injected
public class TrimmedArmorItemModelProvider extends AbstractItemModelProvider {
    private static final String[] TRIM_MATERIALS = {"quartz", "iron", "netherite", "redstone", "copper", "gold", "emerald", "diamond", "lapis", "amethyst"};
    private static final float TRIM_TYPE_COEFFICIENT = 10F;
    private static final String MINECRAFT_TRIM_TYPE = "minecraft:trim_type";
    private static final String TRIM_IDENTIFIER = "_trim_";
    private static final String TRIM_PATH_PREFIX = "trims";
    private static final String ITEMS_DIRECTORY = "items";
    private final ValueChannelBus channelBus;

    public TrimmedArmorItemModelProvider(PackOutput packOutput, ValueChannelBus channelBus) {
        super(packOutput);
        this.channelBus = channelBus;
    }

    @Override
    protected void registerData() {
        this.channelBus.<ItemModelSpec<? extends ArmorItem>>forEachDrain(DataChannels.ITEM_MODEL_PROVIDER_TRIMMED_ARMOR_ITEMS, spec -> {
            ArmorItem item = spec.getItem();
            String parent = ResourceLocationUtils.joinMinecraftPath(ITEM_PATH, GENERATED_PATH);
            String path = RegistryUtils.findItemNamespacedPath(item, ITEM_PATH);
            ItemModel itemModel = BasicItemModel.of(parent, List.of(path), this.createOverrides(path, item, parent));
            this.addItemModel(item, itemModel);
        });
    }

    private List<BasicItemModel.Override> createOverrides(String path, ArmorItem item, String parent) {
        List<BasicItemModel.Override> overrides = new ArrayList<>();
        for (int i = 0; i < TRIM_MATERIALS.length; i++) {
            String trimMaterial = TRIM_MATERIALS[i];
            this.addTrimToOverrides(i, path, overrides, trimMaterial);
            this.createTrimmedArmorItemModel(path, item, trimMaterial, parent);
        }
        return overrides;
    }

    private void addTrimToOverrides(int index, String path, List<BasicItemModel.Override> overrides, String trimMaterial) {
        String trimModelPath = path + TRIM_IDENTIFIER + trimMaterial;
        float trimTypePropertyValue = (index + 1) / TRIM_TYPE_COEFFICIENT;
        Map<String, Float> predicate = Map.of(MINECRAFT_TRIM_TYPE, trimTypePropertyValue);
        BasicItemModel.Override override = new BasicItemModel.Override(trimModelPath, predicate);
        overrides.add(override);
    }

    private void createTrimmedArmorItemModel(String path, ArmorItem item, String trimMaterial, String parent) {
        String trimeMaterialSuffix = TRIM_IDENTIFIER + trimMaterial;
        String trimmedArmorModelPath = ResourceLocationUtils.joinMinecraftPath(TRIM_PATH_PREFIX, ITEMS_DIRECTORY, item.getType().getName() + trimeMaterialSuffix);
        ItemModel trimmedArmorItemModel = BasicItemModel.of(parent, List.of(path, trimmedArmorModelPath));
        this.addItemModel(item, trimmedArmorItemModel, trimeMaterialSuffix);
    }
}
