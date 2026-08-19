package io.bloomish.api.engine.metadata.consumer;

import io.bloomish.api.engine.metadata.processor.StrategySpec;

import java.util.Set;

public interface AnnotationStrategyConsumer {
    void execute(Iterable<StrategySpec<?>> strategies, Set<Class<?>> source);
}
