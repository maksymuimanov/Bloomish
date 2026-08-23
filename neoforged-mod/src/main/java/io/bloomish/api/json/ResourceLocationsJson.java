package io.bloomish.api.json;

import net.minecraft.resources.ResourceLocation;

import java.util.List;

public record ResourceLocationsJson(
        Boolean replace,
        List<ResourceLocation> values
) implements JsonSerializable {
    public ResourceLocationsJson(List<ResourceLocation> values) {
        this(null, values);
    }
}
