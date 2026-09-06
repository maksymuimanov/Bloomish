package io.bloomish.api.compat;

public interface DependencyFlowBuilder<B extends DependencyFlowBuilder<B>> {
    B onDependency(DependencyFunction callback);

    B next(String dependencyId, String... dependencyIds);

    B next(B nextBuilder);

    void build();
}
