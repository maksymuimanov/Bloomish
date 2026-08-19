package io.bloomish.api.json;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.minecraft.resources.ResourceLocation;

import java.util.List;

public record ResourceLocationsRepresentation(
        Boolean replace,
        List<ResourceLocation> values
) implements JsonModel {
    private static final String REPLACE_PROPERTY = "replace";
    private static final String VALUES_PROPERTY = "values";

    public ResourceLocationsRepresentation(List<ResourceLocation> values) {
        this(null, values);
    }

    @Override
    public JsonElement toJson() {
        JsonObject jsonObject = new JsonObject();
        if (replace != null) {
            jsonObject.addProperty(REPLACE_PROPERTY, replace);
        }
        JsonArray jsonArray = new JsonArray();
        for (ResourceLocation value : values) {
            jsonArray.add(value.toString());
        }
        jsonObject.add(VALUES_PROPERTY, jsonArray);
        return jsonObject;
    }
}
