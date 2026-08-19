package io.bloomish.api.engine.registry.registrar;

import net.neoforged.bus.api.IEventBus;

public interface FactoryRegistrar {
    void registerFactories(IEventBus eventBus);
}