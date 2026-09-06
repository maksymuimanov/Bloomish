package io.bloomish.api.initialization.initializer;

import io.bloomish.api.engine.context.ObjectRegistry;

import java.util.Collection;
import java.util.List;

@FunctionalInterface
public interface ObjectRegistryInitializer {
    void initialize(Collection<Class<?>> classes, List<?> externalObjects, ObjectRegistry registry);
}
