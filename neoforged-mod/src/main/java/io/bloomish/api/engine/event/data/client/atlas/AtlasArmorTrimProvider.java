package io.bloomish.api.engine.event.data.client.atlas;

import io.bloomish.api.channel.DataChannels;
import io.bloomish.api.channel.KeyedChannelBus;
import io.bloomish.api.channel.ValueChannelBus;
import io.bloomish.api.engine.event.data.AbstractMultiDataProvider;
import io.bloomish.api.engine.event.data.DataTarget;
import io.bloomish.api.engine.event.data.client.ClientDataProvider;
import io.bloomish.api.engine.metadata.annotation.injection.Injected;
import io.bloomish.api.util.ResourceKeyUtils;
import io.bloomish.api.util.ResourceLocationUtils;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.armortrim.TrimMaterial;
import net.minecraft.world.item.armortrim.TrimMaterials;
import net.minecraft.world.item.armortrim.TrimPattern;
import net.minecraft.world.item.armortrim.TrimPatterns;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Injected
public class AtlasArmorTrimProvider extends AbstractMultiDataProvider implements ClientDataProvider {
    private static final DataTarget DATA_TARGET = DataTarget.createMinecraftResourcePack("atlases/armor_trims");
    private static final String TRIMS_MODELS_ARMOR_PATH = "trims/models/armor/";
    private static final String LEGGINGS_SUFFIX = "_leggings";
    private static final String TRIMS_COLOR_PALETTES_PATH = "trims/color_palettes/";
    private static final String PALETTED_PERMUTATIONS_TYPE = "paletted_permutations";
    private static final String PALETTE_KEY_PATH = "trims/color_palettes/trim_palette";
    private final List<String> trimPatterns;
    private final Map<String, String> trimMaterials;
    private final ValueChannelBus valueChannelBus;
    private final KeyedChannelBus keyedChannelBus;

    public AtlasArmorTrimProvider(PackOutput packOutput, ValueChannelBus valueChannelBus, KeyedChannelBus keyedChannelBus) {
        super(packOutput);
        this.valueChannelBus = valueChannelBus;
        this.keyedChannelBus = keyedChannelBus;
        this.trimPatterns = new ArrayList<>();
        this.trimMaterials = new HashMap<>();
        this.initializeTrimResources();
    }

    private void initializeTrimResources() {
        ResourceKeyUtils.<TrimPattern>extractResourceKeys(TrimPatterns.class)
                .map(ResourceKey::location)
                .map(ResourceLocation::getPath)
                .forEach(this::addDefaultTrimPattern);
        ResourceKeyUtils.<TrimMaterial>extractResourceKeys(TrimMaterials.class)
                .map(ResourceKey::location)
                .map(ResourceLocation::getPath)
                .forEach(this::addDefaultTrimMaterial);
    }

    private void addDefaultTrimPattern(String name) {
        String id = TRIMS_MODELS_ARMOR_PATH + name;
        trimPatterns.add(id);
        trimPatterns.add(id + LEGGINGS_SUFFIX);
    }

    private void addDefaultTrimMaterial(String name) {
        trimMaterials.put(name, TRIMS_COLOR_PALETTES_PATH + name);
    }

    @Override
    protected void registerData() {
        List<AtlasArmorTrim.Source> sources = this.resolveSources();
        AtlasArmorTrim atlasArmorTrim = new AtlasArmorTrim(false, sources);
        this.addData(DATA_TARGET, atlasArmorTrim);
    }

    private List<AtlasArmorTrim.Source> resolveSources() {
        List<String> textures = this.resolveTrimPatternTextures();
        AtlasArmorTrim.Permutations permutations = this.resolveTrimMaterialPermutations();
        AtlasArmorTrim.Source source = new AtlasArmorTrim.Source(PALETTED_PERMUTATIONS_TYPE, textures, PALETTE_KEY_PATH, permutations);
        return List.of(source);
    }

    private List<String> resolveTrimPatternTextures() {
        this.valueChannelBus.<ResourceLocation>forEachDrain(DataChannels.ATLAS_ARMOR_TRIM_PROVIDER_TRIM_PATTERNS, location -> {
            String trimPatternTexture = ResourceLocationUtils.joinPath(location, TRIMS_MODELS_ARMOR_PATH, location.getPath());
            this.trimPatterns.add(trimPatternTexture);
            this.trimPatterns.add(trimPatternTexture + LEGGINGS_SUFFIX);
        });
        return this.trimPatterns;
    }

    private AtlasArmorTrim.Permutations resolveTrimMaterialPermutations() {
        this.keyedChannelBus.<String, ResourceLocation>forEachDrain(DataChannels.ATLAS_ARMOR_TRIM_PROVIDER_TRIM_MATERIALS,
                (assetName, location) ->
                        this.trimMaterials.put(assetName, ResourceLocationUtils.joinPath(location, TRIMS_COLOR_PALETTES_PATH, location.getPath())));
        return new AtlasArmorTrim.Permutations(this.trimMaterials);
    }
}