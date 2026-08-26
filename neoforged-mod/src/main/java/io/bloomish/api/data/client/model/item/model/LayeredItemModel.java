package io.bloomish.api.data.client.model.item.model;

import java.util.Map;

public record LayeredItemModel(
        String parent,
        Map<String, String> textures
) implements ItemModel {
}
