package io.bloomish.api.compat;

import io.bloomish.api.util.CollectionUtils;

import java.util.List;

public class SimpleDependencyFlowBuilder extends AbstractDependencyFlowBuilder<SimpleDependencyFlowBuilder> {
    protected SimpleDependencyFlowBuilder(List<String> dependencyIds) {
        super(dependencyIds);
    }

    public static SimpleDependencyFlowBuilder ofDependencies(String dependencyId, String... dependencyIds) {
        List<String> ids = CollectionUtils.listOf(dependencyId, dependencyIds);
        return new SimpleDependencyFlowBuilder(ids);
    }

    @Override
    public SimpleDependencyFlowBuilder next(String dependencyId, String... dependencyIds) {
        return this.next(ofDependencies(dependencyId, dependencyIds));
    }

    @Override
    public void build() {
        this.getCallbacks().forEach(DependencyFunction::execute);
    }
}
