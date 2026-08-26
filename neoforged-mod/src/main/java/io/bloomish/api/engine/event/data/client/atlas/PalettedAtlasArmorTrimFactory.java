package io.bloomish.api.engine.event.data.client.atlas;

import io.bloomish.api.engine.metadata.annotation.injection.Injected;

import java.util.List;
import java.util.Map;

@Injected
public class PalettedAtlasArmorTrimFactory implements AtlasArmorTrimFactory {
    private static final String PALETTED_PERMUTATIONS_TYPE = "paletted_permutations";
    private static final String PALETTE_KEY_PATH = "trims/color_palettes/trim_palette";
    private final AtlasArmorTrimMaterialCollector atlasArmorTrimMaterialCollector;
    private final AtlasArmorTrimPatternCollector atlasArmorTrimPatternCollector;

    public PalettedAtlasArmorTrimFactory(AtlasArmorTrimMaterialCollector atlasArmorTrimMaterialCollector, AtlasArmorTrimPatternCollector atlasArmorTrimPatternCollector) {
        this.atlasArmorTrimMaterialCollector = atlasArmorTrimMaterialCollector;
        this.atlasArmorTrimPatternCollector = atlasArmorTrimPatternCollector;
    }

    @Override
    public AtlasArmorTrim createAtlasArmorTrim() {
        Map<String, String> materials = this.atlasArmorTrimMaterialCollector.collectMaterials();
        AtlasArmorTrim.Permutations permutations = new AtlasArmorTrim.Permutations(materials);
        List<String> patterns = this.atlasArmorTrimPatternCollector.collectPatterns();
        AtlasArmorTrim.Source source = new AtlasArmorTrim.Source(PALETTED_PERMUTATIONS_TYPE, patterns, PALETTE_KEY_PATH, permutations);
        return new AtlasArmorTrim(false, List.of(source));
    }
}
