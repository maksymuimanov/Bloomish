package io.bloomish.api.engine.initialization.initializer;

import io.bloomish.api.engine.context.ObjectRegistry;
import io.bloomish.api.util.CollectionUtils;
import net.neoforged.bus.api.IEventBus;

import java.util.Collection;
import java.util.List;

public class EventBusInitializer implements ObjectRegistryInitializer {
    @Override
    public void initialize(Collection<Class<?>> classes, List<?> externalObjects, ObjectRegistry objectRegistry) {
        if (CollectionUtils.isEmpty(externalObjects)) return;
        externalObjects.stream()
                .filter(IEventBus.class::isInstance)
                .map(IEventBus.class::cast)
                .findAny()
                .ifPresent(objectRegistry::registerValue);
    }
}
