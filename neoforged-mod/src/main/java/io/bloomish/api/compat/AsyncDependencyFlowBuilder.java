package io.bloomish.api.compat;

import io.bloomish.api.ApiMod;
import io.bloomish.api.util.CollectionUtils;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ForkJoinPool;

public class AsyncDependencyFlowBuilder extends AbstractDependencyFlowBuilder<AsyncDependencyFlowBuilder> {
    private final ExecutorService threadPool;

    public static AsyncDependencyFlowBuilder ofDependencies(String dependencyId, String... dependencyIds) {
        List<String> ids = CollectionUtils.arrayListOf(dependencyId, dependencyIds);
        return new AsyncDependencyFlowBuilder(ForkJoinPool.commonPool(), ids);
    }

    public AsyncDependencyFlowBuilder(ExecutorService threadPool, List<String> dependencyIds) {
        super(dependencyIds);
        this.threadPool = threadPool;
    }

    public CompletableFuture<AsyncDependencyFlowBuilder> nextAsync(String dependencyId, String... dependencyIds) {
        return this.buildAsync()
                .thenApply(ignored -> {
                    List<String> ids = CollectionUtils.arrayListOf(dependencyId, dependencyIds);
                    return new AsyncDependencyFlowBuilder(this.threadPool, ids);
                });
    }

    @Override
    public AsyncDependencyFlowBuilder next(String dependencyId, String... dependencyIds) {
        return this.next(ofDependencies(dependencyId, dependencyIds));
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
