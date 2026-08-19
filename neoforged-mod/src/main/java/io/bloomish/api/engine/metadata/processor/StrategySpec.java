package io.bloomish.api.engine.metadata.processor;

import io.bloomish.api.engine.metadata.strategy.AnnotationStrategy;

public record StrategySpec<T>(AnnotationStrategy<T, ?> strategy, T type) {
}
