package io.bloomish.api.engine.event.data.client.atlas;

import java.util.List;
import java.util.Map;

public record AtlasArmorTrim(
        boolean replace,
        List<Source> sources
) {
    public record Source(
            String type,
            List<String> textures,
            String paletteKey,
            Permutations permutations
    ) {
    }

    public record Permutations(
            Map<String, String> trimMaterials
    ) {
    }
}