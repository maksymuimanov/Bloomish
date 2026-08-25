package io.bloomish.api.engine.registry.factory;

import io.bloomish.api.engine.registry.BloomishRegister;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;

import java.util.function.Supplier;

public abstract class AbstractObjectFactory<R> implements ObjectFactory<R> {
    private final BloomishRegister<R> registry;

    public AbstractObjectFactory(BloomishRegister<R> register) {
        this.registry = register;
    }

    @Override
    public <T extends R> DeferredHolder<R, T> create(String name, Supplier<T> supplier) {
        return this.getRegistry().register(name, supplier);
    }

    @Override
    public void register(IEventBus eventBus, Class<?>... containers) {
        this.getRegistry().register(eventBus, containers);
    }

    @Override
    public BloomishRegister<R> getRegistry() {
        return registry;
    }
}
