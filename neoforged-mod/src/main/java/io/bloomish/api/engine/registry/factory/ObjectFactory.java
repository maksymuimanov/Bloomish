package io.bloomish.api.engine.registry.factory;

import io.bloomish.api.engine.registry.BloomishRegister;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;

import java.util.function.Supplier;

public interface ObjectFactory<R> {
    <T extends R> DeferredHolder<R, T> create(String name, Supplier<T> supplier);

    void register(IEventBus eventBus, Class<?>... containers);

    BloomishRegister<R> getRegistry();
}
