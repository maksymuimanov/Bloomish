package io.bloomish.api.compat;

import io.bloomish.api.engine.event.handler.EventHandler;

public interface DependencyFlowBuilder<B extends DependencyFlowBuilder<B>> {
    B onEvent(EventHandler eventHandler);

    B onDependency(DependencyFunction callback);

    B next(String dependencyId, String... additionalDependencyIds);

    B next(B nextBuilder);

    void build();
}
