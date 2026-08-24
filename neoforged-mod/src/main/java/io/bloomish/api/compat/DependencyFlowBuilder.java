package io.bloomish.api.compat;

import io.bloomish.api.engine.event.EventHandler;

public interface DependencyFlowBuilder<B extends DependencyFlowBuilder<B>> {
    B onEvent(EventHandler eventHandler);

    B onDependency(DependencyFunction callback);

    B next(String dependencyId, String... dependencyIds);

    B next(B nextBuilder);

    void build();
}
