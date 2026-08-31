package io.bloomish.api.data.client.model.item.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public record LayeredItemModel(
        String parent,
        List<Override> overrides,
        Map<String, String> textures
) implements ItemModel {
    private static final String LAYER_PREFIX = "layer";

    public static LayeredItemModel ofParent(String parent) {
        return ofLayers(parent, null);
    }

    public static LayeredItemModel ofLayer(String parent, String layer0) {
        return ofLayers(parent, List.of(layer0));
    }

    public static LayeredItemModel ofLayer(String parent, String layer0, List<Override> overrides) {
        return ofLayers(parent, List.of(layer0), overrides);
    }

    public static LayeredItemModel ofLayers(String parent, List<String> layers) {
        return ofLayers(parent, layers, null);
    }

    public static LayeredItemModel ofLayers(String parent, List<String> layers, List<Override> overrides) {
        Map<String, String> textures = null;
        if (layers != null) {
            textures = new HashMap<>();
            for (int i = 0; i < layers.size(); i++) {
                String currentLayerKey = LAYER_PREFIX + i;
                String currentLayerValue = layers.get(i);
                textures.put(currentLayerKey, currentLayerValue);
            }
        }
        return new LayeredItemModel(parent, overrides, textures);
    }

    public record Override(
            String model,
            Map<String, ?> predicate
    ) {
    }
}
