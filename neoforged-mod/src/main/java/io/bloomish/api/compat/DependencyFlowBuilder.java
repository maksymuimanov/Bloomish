package io.bloomish.api.core.compat;

import io.bloomish.api.engine.event.handler.EventHandler;

import java.util.function.Supplier;

public interface DependencyFlowBuilder<B extends DependencyFlowBuilder<B>> {
    B onEvent(EventHandler eventHandler);

    B onDependency(DependencyFunction callback);

    B next(String dependencyId, String... additionalDependencyIds);

    B next(B nextBuilder);

    void build();
}
