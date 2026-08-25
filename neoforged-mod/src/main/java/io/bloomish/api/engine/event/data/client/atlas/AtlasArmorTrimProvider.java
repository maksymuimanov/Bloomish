package io.bloomish.api.engine.event.data.client.atlas;

import io.bloomish.api.core.collection.TemporalMap;
import io.bloomish.api.core.collection.TemporalQueue;
import io.bloomish.api.engine.event.data.file.SingleFileProvider;
import io.bloomish.api.json.AtlasArmorTrimJson;
import io.bloomish.api.json.JsonSerializable;
import io.bloomish.api.util.ResourceUtils;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.armortrim.TrimMaterial;
import net.minecraft.world.item.armortrim.TrimMaterials;
import net.minecraft.world.item.armortrim.TrimPattern;
import net.minecraft.world.item.armortrim.TrimPatterns;

import java.util.*;

public class AtlasArmorTrimProvider extends SingleFileProvider {
    public static final Queue<ResourceLocation> TRIM_PATTERNS_LOCATIONS = new TemporalQueue<>();
    public static final Map<String, ResourceLocation> TRIM_MATERIALS_LOCATIONS = new TemporalMap<>();
    public static final String PATH = "atlases/armor_trims.json";
    public static final String TRIMS_MODELS_ARMOR_PATH = "trims/models/armor/";
    public static final String LEGGINGS_SUFFIX = "_leggings";
    public static final String TRIMS_COLOR_PALETTES_PATH = "trims/color_palettes/";
    public static final String PALETTED_PERMUTATIONS_TYPE = "paletted_permutations";
    public static final String PALETTE_KEY_PATH = "trims/color_palettes/trim_palette";
    protected static final List<String> DEFAULT_TRIM_PATTERNS = new ArrayList<>();
    protected static final Map<String, String> DEFAULT_TRIM_MATERIALS = new HashMap<>();

    static {
        ResourceUtils.<TrimPattern>getResourceKeyStream(TrimPatterns.class)
                .map(ResourceKey::location)
                .map(ResourceLocation::getPath)
                .forEach(AtlasArmorTrimProvider::addDefaultTrimPattern);
        ResourceUtils.<TrimMaterial>getResourceKeyStream(TrimMaterials.class)
                .map(ResourceKey::location)
                .map(ResourceLocation::getPath)
                .forEach(AtlasArmorTrimProvider::addDefaultTrimMaterial);
        addDefaultTrimMaterial("iron_darker");
        addDefaultTrimMaterial("gold_darker");
        addDefaultTrimMaterial("diamond_darker");
        addDefaultTrimMaterial("netherite_darker");
    }

    protected static void addDefaultTrimPattern(String name) {
        String id = TRIMS_MODELS_ARMOR_PATH + name;
        DEFAULT_TRIM_PATTERNS.add(id);
        DEFAULT_TRIM_PATTERNS.add(id + LEGGINGS_SUFFIX);
    }

    protected static void addDefaultTrimMaterial(String name) {
        DEFAULT_TRIM_MATERIALS.put(name, TRIMS_COLOR_PALETTES_PATH + name);
    }

    public AtlasArmorTrimProvider(PackOutput output) {
        super(output, PackOutput.Target.RESOURCE_PACK, PATH, ResourceLocation.DEFAULT_NAMESPACE);
    }

    @Override
    public void registerFile() {
        List<String> textures = this.createTextures();
        AtlasArmorTrimJson.Permutations permutations = this.createPermutations();
        AtlasArmorTrimJson.Source[] sources = this.createSources(textures, permutations);
        JsonSerializable representation = new AtlasArmorTrimJson(false, sources);
        this.define(representation);
    }

    protected AtlasArmorTrimJson.Source[] createSources(List<String> textures, AtlasArmorTrimJson.Permutations permutations) {
        AtlasArmorTrimJson.Source source = new AtlasArmorTrimJson.Source(
                PALETTED_PERMUTATIONS_TYPE,
                textures,
                PALETTE_KEY_PATH,
                permutations
        );
        return new AtlasArmorTrimJson.Source[]{source};
    }

    protected List<String> createTextures() {
        List<String> trimPatterns = new ArrayList<>(DEFAULT_TRIM_PATTERNS);
        TRIM_PATTERNS_LOCATIONS.forEach(location -> {
            String namespace = location.getNamespace();
            String path = location.getPath();
            String id = namespace + ":" + TRIMS_MODELS_ARMOR_PATH + path;
            trimPatterns.add(id);
            trimPatterns.add(id + LEGGINGS_SUFFIX);
        });
        return trimPatterns;
    }

    protected AtlasArmorTrimJson.Permutations createPermutations() {
        Map<String, String> trimMaterials = new HashMap<>(DEFAULT_TRIM_MATERIALS);
        TRIM_MATERIALS_LOCATIONS.forEach((key, value) -> {
            trimMaterials.put(key, value.getNamespace() + ":" + TRIMS_COLOR_PALETTES_PATH + value.getPath());
        });
        return new AtlasArmorTrimJson.Permutations(trimMaterials);
    }
}