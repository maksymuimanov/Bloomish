package io.bloomish.api.compat;

import io.bloomish.api.ApiMod;
import io.bloomish.api.engine.event.handler.EventHandler;
import net.neoforged.fml.ModList;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

public abstract class AbstractDependencyFlowBuilder<B extends AbstractDependencyFlowBuilder<B>>
        implements DependencyFlowBuilder<B> {
    private final List<String> dependencyIds;
    private final Queue<DependencyFunction> callbacks;

    protected AbstractDependencyFlowBuilder(List<String> dependencyIds) {
        this(dependencyIds, new ArrayDeque<>());
    }

    protected AbstractDependencyFlowBuilder(List<String> dependencyIds, Queue<DependencyFunction> callbacks) {
        this.dependencyIds = dependencyIds;
        this.callbacks = callbacks;
    }

    @Override
    public B onEvent(EventHandler eventHandler) {
        return this.onDependency(eventHandler::handle);
    }

    @SuppressWarnings("unchecked")
    @Override
    public B onDependency(DependencyFunction callback) {
        for (String dependencyId : this.getDependencyIds()) {
            boolean isMissingDependency = !ModList.get().isLoaded(dependencyId);
            if (isMissingDependency) {
                ApiMod.LOGGER.warn("Dependency: \"{}\" is not found, so dependency process won't be added to callbacks: {}", dependencyId, callback.toString());
                return (B) this;
            }
        }

        this.addCallback(callback);
        return (B) this;
    }

    @Override
    public B next(B nextBuilder) {
        this.build();
        return nextBuilder;
    }

    protected List<String> getDependencyIds() {
        return dependencyIds;
    }

    protected Queue<DependencyFunction> getCallbacks() {
        return callbacks;
    }

    protected void addCallback(DependencyFunction callback) {
        callbacks.add(callback);
    }
}
