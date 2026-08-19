package io.bloomish.api.engine.registry;

import io.bloomish.api.engine.EngineBuilder;
import io.bloomish.api.engine.registry.registrar.FactoryRegistrar;
import io.bloomish.api.engine.registry.registrar.FieldTypeFactoryRegistrar;

import java.util.List;

public class RegistryLayerBuilder {
    private static final List<FactoryRegistrar> DEFAULT_FACTORY_REGISTRARS = List.of(new FieldTypeFactoryRegistrar());
    private final EngineBuilder engineBuilder;
    private final RegistryLayer registryLayer;
    private List<FactoryRegistrar> factoryRegistrars = DEFAULT_FACTORY_REGISTRARS;

    public RegistryLayerBuilder(EngineBuilder engineBuilder) {
        this.engineBuilder = engineBuilder;
        this.registryLayer = new RegistryLayer();
        this.engineBuilder.addLayer(this.registryLayer);
    }

    public RegistryLayerBuilder factoryRegistrars(List<FactoryRegistrar> factoryRegistrars) {
        this.factoryRegistrars = factoryRegistrars;
        return this;
    }

    public EngineBuilder and() {
        this.registryLayer.setFactoryRegistrars(this.factoryRegistrars);
        this.engineBuilder.processLayer(this.registryLayer);
        return this.engineBuilder;
    }
}
