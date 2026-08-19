package io.bloomish.api.json;

import com.google.gson.JsonElement;
import net.minecraft.resources.ResourceLocation;

import java.util.List;

public record ResourceLocationsJson(
        Boolean replace,
        List<ResourceLocation> values
) implements JsonSerializable {
    private static final String REPLACE_PROPERTY = "replace";
    private static final String VALUES_PROPERTY = "values";

    public ResourceLocationsJson(List<ResourceLocation> values) {
        this(null, values);
    }

    @Override
    public JsonElement toJson() {
        return JsonUtils.buildJson(json -> {
            JsonUtils.addPropertyIfNotNull(json, REPLACE_PROPERTY, replace);
            json.add(VALUES_PROPERTY, JsonUtils.convertResourceLocationList(values));
        });
    }
}
