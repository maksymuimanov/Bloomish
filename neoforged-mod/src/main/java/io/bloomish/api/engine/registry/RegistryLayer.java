package io.bloomish.api.engine.registry;

import io.bloomish.api.ApiMod;
import io.bloomish.api.engine.EngineLayer;
import io.bloomish.api.engine.context.EngineContext;
import io.bloomish.api.engine.context.ObjectRegistry;
import io.bloomish.api.engine.registry.registrar.FactoryRegistrar;
import net.neoforged.bus.api.IEventBus;

import java.util.List;

public class RegistryLayer implements EngineLayer {
    private List<FactoryRegistrar> factoryRegistrars;

    @Override
    public void process() {
        ObjectRegistry objectRegistry = EngineContext.getRegistry();
        IEventBus eventBus = objectRegistry.getByClass(IEventBus.class);
        factoryRegistrars.forEach(factoryRegistrar -> {
            ApiMod.LOGGER.debug("Registering factories with {}", factoryRegistrar.getClass().getName());
            factoryRegistrar.registerFactories(eventBus);
        });
    }

    public void setFactoryRegistrars(List<FactoryRegistrar> factoryRegistrars) {
        this.factoryRegistrars = factoryRegistrars;
    }
}
