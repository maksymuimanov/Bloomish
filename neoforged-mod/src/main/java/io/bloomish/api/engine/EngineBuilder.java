package io.bloomish.api.engine;

import io.bloomish.api.ApiMod;
import io.bloomish.api.engine.config.ConfigLayerBuilder;
import io.bloomish.api.engine.context.ModContext;
import io.bloomish.api.engine.event.EventLayerBuilder;
import io.bloomish.api.engine.finalization.FinalizationLayerBuilder;
import io.bloomish.api.engine.initialization.InitializationLayerBuilder;
import io.bloomish.api.engine.metadata.MetadataLayerBuilder;
import io.bloomish.api.engine.registry.RegistryLayerBuilder;

public class EngineBuilder {
    private final LayerContainer layerContainer = LayerContainer.getInstance();

    protected EngineBuilder() {
    }

    public EngineBuilder addLayer(EngineLayer engineLayer) {
        this.layerContainer.add(engineLayer);
        return this;
    }

    public EngineBuilder disableLayer(Class<? extends EngineLayer> engineLayerClass) {
        this.layerContainer.delete(engineLayerClass);
        return this;
    }
    
    public InitializationLayerBuilder configureInitializationLayer() {
        return new InitializationLayerBuilder(this);
    }

    public RegistryLayerBuilder configureRegistryLayer() {
        return new RegistryLayerBuilder(this);
    }

    public MetadataLayerBuilder configureMetadataLayer() {
        return new MetadataLayerBuilder(this);
    }

    public EventLayerBuilder configureEventLayer() {
        return new EventLayerBuilder(this);
    }

    public ConfigLayerBuilder configureConfigLayer() {
        return new ConfigLayerBuilder(this);
    }

    public FinalizationLayerBuilder configureFinalizationLayer() {
        return new FinalizationLayerBuilder(this);
    }

    public LayerContainer build() {
        ApiMod.LOGGER.info("Mod: {} has been registered as a TemporalEngine component!", ModContext.NEO_MOD.getModId());
        return this.layerContainer;
    }
    
    public void processLayer(EngineLayer engineLayer) {
        String layerName = engineLayer.getClass().getName();
        ApiMod.LOGGER.info("Layer: {} is going to be processed!", layerName);
        engineLayer.processAllTasks();
        ApiMod.LOGGER.info("Layer: {} has been processed!", layerName);
    }
}
