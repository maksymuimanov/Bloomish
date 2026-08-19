package io.bloomish.api.json;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.List;
import java.util.Map;

public record AtlasArmorTrimJson(
        boolean replace,
        List<Source> sources
) implements JsonModel {
    private static final String REPLACE_PROPERTY = "replace";
    private static final String SOURCES_PROPERTY = "sources";

    @Override
    public JsonElement toJson() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty(REPLACE_PROPERTY, replace);
        JsonArray jsonArray = new JsonArray();
        for (Source source : sources) {
            JsonElement sourceJson = source.toJson();
            jsonArray.add(sourceJson);
        }
        jsonObject.add(SOURCES_PROPERTY, jsonArray);
        return jsonObject;
    }

    public record Source(
            String type,
            List<String> textures,
            String paletteKey,
            StringMapJson permutations
    ) implements JsonModel {
        private static final String TYPE_PROPERTY = "type";
        private static final String TEXTURES_PROPERTY = "textures";
        private static final String PALETTE_KEY_PROPERTY = "palette_key";
        private static final String PERMUTATIONS_PROPERTY = "permutations";

        @Override
        public JsonElement toJson() {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty(TYPE_PROPERTY, type);
            JsonArray textureJsonArray = new JsonArray();
            for (String texture : textures) {
                textureJsonArray.add(texture);
            }
            jsonObject.add(TEXTURES_PROPERTY, textureJsonArray);
            jsonObject.addProperty(PALETTE_KEY_PROPERTY, paletteKey);
            jsonObject.add(PERMUTATIONS_PROPERTY, permutations.toJson());
            return jsonObject;
        }
    }
}