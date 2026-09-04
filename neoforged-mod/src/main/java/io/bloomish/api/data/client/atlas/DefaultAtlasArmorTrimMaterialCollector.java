package io.bloomish.api.data.client.atlas;

import io.bloomish.api.channel.DataChannels;
import io.bloomish.api.channel.KeyedChannelBus;
import io.bloomish.api.engine.metadata.annotation.injection.Injected;
import io.bloomish.api.util.ResourceKeyUtils;
import io.bloomish.api.util.ResourceLocationUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.armortrim.TrimMaterial;
import net.minecraft.world.item.armortrim.TrimMaterials;

import java.util.HashMap;
import java.util.Map;

@Injected
public class DefaultAtlasArmorTrimMaterialCollector implements AtlasArmorTrimMaterialCollector {
    private static final String TRIMS_COLOR_PALETTES_PATH = "trims/color_palettes/";
    private final Map<String, String> trimMaterials;
    private final KeyedChannelBus channelBus;

    public DefaultAtlasArmorTrimMaterialCollector(KeyedChannelBus channelBus) {
        this.channelBus = channelBus;
        this.trimMaterials = new HashMap<>();
        this.initializeDefaultMaterials();
    }

    private void initializeDefaultMaterials() {
        ResourceKeyUtils.<TrimMaterial>extractResourceKeys(TrimMaterials.class)
                .map(ResourceKey::location)
                .map(ResourceLocation::getPath)
                .forEach(path -> this.trimMaterials.put(path, TRIMS_COLOR_PALETTES_PATH + path));
    }

    @Override
    public Map<String, String> collectMaterials() {
        this.channelBus.<String, ResourceLocation>forEachDrain(DataChannels.ATLAS_ARMOR_TRIM_PROVIDER_TRIM_MATERIALS,
                (assetName, location) ->
                        this.trimMaterials.put(assetName, ResourceLocationUtils.joinNamespacedPath(location, TRIMS_COLOR_PALETTES_PATH)));
        return Map.copyOf(this.trimMaterials);
    }
}
