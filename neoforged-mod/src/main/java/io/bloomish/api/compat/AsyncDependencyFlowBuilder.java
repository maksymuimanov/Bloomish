package io.bloomish.api.compat;

import io.bloomish.api.ApiMod;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class AsyncDependencyFlowBuilder extends AbstractDependencyFlowBuilder<AsyncDependencyFlowBuilder> {
    private final ExecutorService threadPool;

    public static AsyncDependencyFlowBuilder ofDependencies(String dependencyId, String... additionalDependencyIds) {
        List<String> ids = new ArrayList<>(additionalDependencyIds.length + 1);
        ids.add(dependencyId);
        ids.addAll(List.of(additionalDependencyIds));
        return new AsyncDependencyFlowBuilder(ForkJoinPool.commonPool(), ids);
    }

    public AsyncDependencyFlowBuilder(
            ExecutorService threadPool,
            List<String> dependencyIds
    ) {
        super(dependencyIds);
        this.threadPool = threadPool;
    }


    @Override
    public AsyncDependencyFlowBuilder next(String dependencyId, String... additionalDependencyIds) {
        return this.next(ofDependencies(dependencyId, additionalDependencyIds));
    }

    @Override
    public void build() {
        this.buildAsync();
    }

    public CompletableFuture<Void> buildAsync() {
        return CompletableFuture.allOf(this.getCallbacks()
                .stream()
                .map(callback ->
                        CompletableFuture.runAsync(() -> executeCallback(callback), threadPool))
                .toArray(CompletableFuture[]::new));
    }

    private void executeCallback(DependencyFunction callback) {
        try {
            callback.execute();
        } catch (Exception e) {
            ApiMod.LOGGER.error("Error while running dependency process", e);
            throw new DependencyFlowException(e);
        }
    }
}
