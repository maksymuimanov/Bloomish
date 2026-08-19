package io.bloomish.api.json;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.List;
import java.util.Map;

public record AtlasArmorTrimJson(
        boolean replace,
        List<Source> sources
) implements JsonSerializable {
    private static final String REPLACE_PROPERTY = "replace";
    private static final String SOURCES_PROPERTY = "sources";

    @Override
    public JsonElement toJson() {
        return JsonUtils.buildJson(json -> {
            json.addProperty(REPLACE_PROPERTY, replace);
            json.add(SOURCES_PROPERTY, JsonUtils.convertJsonSerializableList(sources));
        });
    }

    public record Source(
            String type,
            List<String> textures,
            String paletteKey,
            Permutations permutations
    ) implements JsonSerializable {
        private static final String TYPE_PROPERTY = "type";
        private static final String TEXTURES_PROPERTY = "textures";
        private static final String PALETTE_KEY_PROPERTY = "palette_key";
        private static final String PERMUTATIONS_PROPERTY = "permutations";

        @Override
        public JsonElement toJson() {
            return JsonUtils.buildJson(json -> {
                json.addProperty(TYPE_PROPERTY, type);
                json.add(TEXTURES_PROPERTY, JsonUtils.convertStringList(textures));
                json.addProperty(PALETTE_KEY_PROPERTY, paletteKey);
                json.add(PERMUTATIONS_PROPERTY, permutations.toJson());
            });
        }
    }

    public record Permutations(
            Map<String, String> trimMaterials
    ) implements JsonSerializable {
        @Override
        public JsonElement toJson() {
            return JsonUtils.convertMap(trimMaterials);
        }
    }
}