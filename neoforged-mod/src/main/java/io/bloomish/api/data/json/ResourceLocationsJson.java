package io.bloomish.api.data.json;

import io.bloomish.api.assertion.Assertions;
import net.minecraft.resources.ResourceLocation;

import java.util.List;

public record ResourceLocationsJson(
        Boolean replace,
        List<ResourceLocation> values
) {

    public ResourceLocationsJson(List<ResourceLocation> values) {
        this(null, values);
    }

    public ResourceLocationsJson(Boolean replace, List<ResourceLocation> values) {
        Assertions.assertThat(values).isNotNull();
        this.replace = replace;
        this.values = List.copyOf(values);
    }
}
