package io.bloomish.api.core.compat;

import java.util.ArrayList;
import java.util.List;

public class SimpleDependencyFlowBuilder extends AbstractDependencyFlowBuilder<SimpleDependencyFlowBuilder> {
    protected SimpleDependencyFlowBuilder(List<String> dependencyIds) {
        super(dependencyIds);
    }

    public static SimpleDependencyFlowBuilder ofDependencies(String dependencyId, String... additionalDependencyIds) {
        List<String> ids = new ArrayList<>(additionalDependencyIds.length + 1);
        ids.add(dependencyId);
        ids.addAll(List.of(additionalDependencyIds));
        return new SimpleDependencyFlowBuilder(ids);
    }

    @Override
    public SimpleDependencyFlowBuilder next(String dependencyId, String... additionalDependencyIds) {
        return this.next(ofDependencies(dependencyId, additionalDependencyIds));
    }

    @Override
    public void build() {
        this.getCallbacks().forEach(DependencyFunction::execute);
    }
}
