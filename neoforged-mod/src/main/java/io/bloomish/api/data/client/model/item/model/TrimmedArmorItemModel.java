package io.bloomish.api.data.client.model.item.model;

import java.util.List;
import java.util.Map;

public record TrimmedArmorItemModel(
        String parent,
        List<Override> overrides,
        Map<String, String> textures
) implements ItemModel {
    public record Override(
            String model,
            Map<String, Float> predicate
    ) {
    }
}
