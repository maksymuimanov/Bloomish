package io.bloomish.api.engine;

import io.bloomish.api.ApiMod;
import io.bloomish.api.engine.config.ConfigLayer;
import io.bloomish.api.engine.config.ConfigLayerCustomizer;
import io.bloomish.api.engine.context.EngineContext;
import io.bloomish.api.engine.event.EventLayer;
import io.bloomish.api.engine.finalization.FinalizationLayer;
import io.bloomish.api.engine.finalization.FinalizationLayerCustomizer;
import io.bloomish.api.engine.initialization.InitializationLayer;
import io.bloomish.api.engine.initialization.InitializationLayerCustomizer;
import io.bloomish.api.engine.metadata.MetadataLayer;
import io.bloomish.api.engine.metadata.MetadataLayerCustomizer;
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
        return this.metadataLayer(layerCustomizer -> {});
    }

    public EngineBuilder metadataLayer(Consumer<MetadataLayerCustomizer> customizerConsumer) {
        MetadataLayer metadataLayer = new MetadataLayer();
        MetadataLayerCustomizer layerCustomizer = new MetadataLayerCustomizer();
        customizerConsumer.accept(layerCustomizer);
        return this.configureLayer(metadataLayer, layerCustomizer);
    }

    public EngineBuilder eventLayer() {
        EventLayer eventLayer = new EventLayer();
        this.addLayer(eventLayer);
        return this;
    }

    public EngineBuilder configLayer() {
        return this.configLayer(layerCustomizer -> {});
    }

    public EngineBuilder configLayer(Consumer<ConfigLayerCustomizer> customizerConsumer) {
        ConfigLayer configLayer = new ConfigLayer();
        ConfigLayerCustomizer layerCustomizer = new ConfigLayerCustomizer();
        customizerConsumer.accept(layerCustomizer);
        return this.configureLayer(configLayer, layerCustomizer);
    }

    public EngineBuilder finalizationLayer() {
        return this.finalizationLayer(layerCustomizer -> {});
    }

    public EngineBuilder finalizationLayer(Consumer<FinalizationLayerCustomizer> customizerConsumer) {
        FinalizationLayer finalizationLayer = new FinalizationLayer();
        FinalizationLayerCustomizer layerCustomizer = new FinalizationLayerCustomizer();
        customizerConsumer.accept(layerCustomizer);
        return this.configureLayer(finalizationLayer, layerCustomizer);
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
        ApiMod.LOGGER.info("Mod: {} has been registered as a Bloomish component!", EngineContext.currentMod.getModId());
        return this.layerContainer;
    }

    private void processLayer(EngineLayer engineLayer) {
        String layerName = engineLayer.getClass().getName();
        ApiMod.LOGGER.info("Layer: {} is going to be processed!", layerName);
        engineLayer.process();
        ApiMod.LOGGER.info("Layer: {} has been processed!", layerName);
    }
}
