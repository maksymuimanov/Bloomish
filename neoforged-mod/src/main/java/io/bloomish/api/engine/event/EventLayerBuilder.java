package io.bloomish.api.engine.event;

import io.bloomish.api.engine.EngineBuilder;

public class EventLayerBuilder {
    private final EngineBuilder engineBuilder;
    private final EventLayer eventLayer;

    public EventLayerBuilder(EngineBuilder engineBuilder) {
        this.engineBuilder = engineBuilder;
        this.eventLayer = new EventLayer();
        this.engineBuilder.addLayer(this.eventLayer);
    }

    public EngineBuilder and() {
        this.engineBuilder.processLayer(eventLayer);
        return this.engineBuilder;
    }
}
