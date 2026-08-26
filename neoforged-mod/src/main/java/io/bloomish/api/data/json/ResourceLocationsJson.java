package io.bloomish.api.data.json;

import net.minecraft.resources.ResourceLocation;

import java.util.List;

public record ResourceLocationsJson(
        Boolean replace,
        List<ResourceLocation> values
) {
    public ResourceLocationsJson(List<ResourceLocation> values) {
        this(null, values);
    }
}
