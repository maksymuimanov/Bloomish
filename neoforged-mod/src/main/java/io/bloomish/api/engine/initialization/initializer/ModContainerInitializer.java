package io.bloomish.api.engine.initialization.initializer;

import io.bloomish.api.engine.context.ObjectRegistry;
import io.bloomish.api.engine.initialization.ObjectRegistryInitializer;
import net.neoforged.fml.ModContainer;

import java.util.Collection;
import java.util.List;

public class ModContainerInitializer implements ObjectRegistryInitializer {
    @Override
    public void initialize(Collection<Class<?>> classes, List<?> externalObjects, ObjectRegistry objectRegistry) {
        if (externalObjects == null || externalObjects.isEmpty()) return;
        externalObjects.stream()
                .filter(ModContainer.class::isInstance)
                .map(ModContainer.class::cast)
                .findAny()
                .ifPresent(objectRegistry::registerValue);
    }
}
