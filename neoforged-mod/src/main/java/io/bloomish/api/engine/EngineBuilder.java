package io.bloomish.api.engine;

import io.bloomish.api.ApiMod;
import io.bloomish.api.context.ModContext;
import io.bloomish.api.engine.config.ConfigLayer;
import io.bloomish.api.engine.finalization.FinalizationLayer;
import io.bloomish.api.engine.initialization.InitializationLayer;
import io.bloomish.api.engine.initialization.InitializationLayerCustomizer;
import io.bloomish.api.engine.metadata.MetadataLayer;
import io.bloomish.api.engine.registry.RegistryLayer;
import io.bloomish.api.engine.registry.RegistryLayerCustomizer;

import java.util.function.Consumer;

public class EngineBuilder {
    private final LayerContainer layerContainer;

    protected EngineBuilder() {
        this.layerContainer = new LayerContainer();
    }

    public EngineBuilder initializationLayer(Consumer<InitializationLayerCustomizer> customizerConsumer) {
        InitializationLayer initializationLayer = new InitializationLayer();
        InitializationLayerCustomizer layerCustomizer = new InitializationLayerCustomizer();
        customizerConsumer.accept(layerCustomizer);
        return this.configureLayer(initializationLayer, layerCustomizer);
    }

    public EngineBuilder registryLayer() {
        return this.registryLayer(layerCustomizer -> {});
    }

    public EngineBuilder registryLayer(Consumer<RegistryLayerCustomizer> customizerConsumer) {
        RegistryLayer registryLayer = new RegistryLayer();
        RegistryLayerCustomizer layerCustomizer = new RegistryLayerCustomizer();
        customizerConsumer.accept(layerCustomizer);
        return this.configureLayer(registryLayer, layerCustomizer);
    }

    public EngineBuilder metadataLayer() {
        EngineLayer metadataLayer = new MetadataLayer();
        this.addLayer(metadataLayer);
        return this;
    }

    public EngineBuilder configLayer() {
        EngineLayer configLayer = new ConfigLayer();
        this.addLayer(configLayer);
        return this;
    }

    public EngineBuilder finalizationLayer() {
        EngineLayer finalizationLayer = new FinalizationLayer();
        this.addLayer(finalizationLayer);
        return this;
    }

    private <L extends EngineLayer, C extends LayerCustomizer<L>> EngineBuilder configureLayer(L layer, C customizer) {
        customizer.customize(layer);
        this.addLayer(layer);
        return this;
    }

    public EngineBuilder addLayer(EngineLayer engineLayer) {
        this.layerContainer.addLayer(engineLayer);
        return this;
    }

    public EngineBuilder disableLayer(Class<? extends EngineLayer> engineLayerClass) {
        this.layerContainer.deleteLayer(engineLayerClass);
        return this;
    }

    public LayerContainer build() {
        this.layerContainer.getLayers().forEach(this::processLayer);
        ApiMod.LOGGER.info("Mod: {} has been registered as a Bloomish component!", ModContext.getModId());
        return this.layerContainer;
    }

    private void processLayer(EngineLayer engineLayer) {
        String layerName = engineLayer.getClass().getName();
        ApiMod.LOGGER.info("Layer: {} is going to be processed!", layerName);
        engineLayer.process();
        ApiMod.LOGGER.info("Layer: {} has been processed!", layerName);
    }
}
