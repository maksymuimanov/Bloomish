package io.bloomish.api.initialization.initializer;

import io.bloomish.api.engine.context.ObjectRegistry;
import net.neoforged.fml.ModContainer;

import java.util.Collection;
import java.util.List;

public class ModContainerInitializer implements ObjectRegistryInitializer {
    @Override
    public void initialize(Collection<Class<?>> classes, List<?> externalObjects, ObjectRegistry registry) {
        if (externalObjects == null || externalObjects.isEmpty()) return;
        externalObjects.stream()
                .filter(ModContainer.class::isInstance)
                .map(ModContainer.class::cast)
                .findAny()
                .ifPresent(registry::registerValue);
    }
}
