package io.bloomish.api.engine;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class LayerContainer {
    private final Collection<EngineLayer> layers;

    public LayerContainer() {
        this(List.of());
    }

    public LayerContainer(Collection<? extends EngineLayer> layers) {
        this.layers = new ArrayList<>(layers);
    }

    protected void addAll(Collection<? extends EngineLayer> engineLayers) {
        layers.addAll(engineLayers);
    }

    protected void addLayer(EngineLayer engineLayer) {
        layers.add(engineLayer);
    }

    public Collection<EngineLayer> getLayers() {
        return Collections.unmodifiableCollection(layers);
    }

    @SuppressWarnings("unchecked")
    public <T extends EngineLayer> T getLayer(Class<T> clazz) {
        return (T) layers.stream()
                .filter(engineLayer -> engineLayer.getClass().equals(clazz))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("Could not find layer with class: " + clazz));
    }

    protected void deleteLayer(Class<? extends EngineLayer> clazz) {
        layers.removeIf(engineLayer -> engineLayer.getClass().equals(clazz));
    }

    protected void deleteAll(Collection<Class<? extends EngineLayer>> layers) {
        layers.forEach(this::deleteLayer);
    }
}
