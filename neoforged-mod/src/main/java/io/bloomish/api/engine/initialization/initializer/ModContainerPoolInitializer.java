package io.bloomish.api.engine.initialization.initializer;

import io.bloomish.api.engine.context.ObjectRegistry;
import net.neoforged.fml.ModContainer;

import java.util.Collection;
import java.util.List;

public class ModContainerPoolInitializer implements ObjectPoolInitializer {
    @Override
    public void initialize(Collection<Class<?>> classes, List<?> externalObjects, ObjectRegistry objectRegistry) {
        if (externalObjects == null || externalObjects.isEmpty()) return;
        externalObjects.stream()
                .filter(o -> o instanceof ModContainer)
                .map(o -> (ModContainer)o)
                .forEach(objectRegistry::register);
    }
}
