package io.bloomish.api.json;

import java.util.List;
import java.util.Map;

public record AtlasArmorTrimJson(
        boolean replace,
        List<Source> sources
) implements JsonSerializable {
    public record Source(
            String type,
            List<String> textures,
            String paletteKey,
            Permutations permutations
    ) implements JsonSerializable {
    }

    public record Permutations(
            Map<String, String> trimMaterials
    ) implements JsonSerializable {
    }
}