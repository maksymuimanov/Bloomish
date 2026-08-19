package io.bloomish.api.engine.registry;

import io.bloomish.api.engine.LayerCustomizer;
import io.bloomish.api.engine.registry.registrar.FactoryRegistrar;
import io.bloomish.api.engine.registry.registrar.FieldTypeFactoryRegistrar;

import java.util.List;

public class RegistryLayerCustomizer implements LayerCustomizer<RegistryLayer> {
    private static final List<FactoryRegistrar> DEFAULT_FACTORY_REGISTRARS = List.of(new FieldTypeFactoryRegistrar());
    private List<FactoryRegistrar> factoryRegistrars;

    public RegistryLayerCustomizer() {
        this.factoryRegistrars = DEFAULT_FACTORY_REGISTRARS;
    }

    public RegistryLayerCustomizer factoryRegistrars(List<FactoryRegistrar> factoryRegistrars) {
        this.factoryRegistrars = factoryRegistrars;
        return this;
    }

    @Override
    public void customize(RegistryLayer layer) {
        layer.setFactoryRegistrars(this.factoryRegistrars);
    }
}
