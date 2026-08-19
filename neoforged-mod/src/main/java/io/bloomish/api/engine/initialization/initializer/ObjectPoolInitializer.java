package io.bloomish.api.engine.initialization.initializer;

import io.bloomish.api.engine.context.ObjectRegistry;

import java.util.Collection;
import java.util.List;

@FunctionalInterface
public interface ObjectPoolInitializer {
    void initialize(Collection<Class<?>> classes, List<?> externalObjects, ObjectRegistry objectRegistry);
}
