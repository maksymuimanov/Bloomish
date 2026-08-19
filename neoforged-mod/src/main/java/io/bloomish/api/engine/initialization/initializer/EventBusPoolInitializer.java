package io.bloomish.api.engine.initialization.initializer;

import io.bloomish.api.engine.context.ObjectRegistry;
import net.neoforged.bus.EventBus;
import net.neoforged.bus.api.IEventBus;

import java.util.Collection;
import java.util.List;

public class EventBusPoolInitializer implements ObjectPoolInitializer {
    @Override
    @SuppressWarnings("UnstableApiUsage")
    public void initialize(Collection<Class<?>> classes, List<?> externalObjects, ObjectRegistry objectRegistry) {
        if (externalObjects == null || externalObjects.isEmpty()) return;
        externalObjects.stream()
                .filter(o -> o instanceof IEventBus)
                .map(o -> (EventBus) o)
                .forEach(objectRegistry::register);
    }
}
