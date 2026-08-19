package io.bloomish.api.engine.metadata.processor;

public interface AnnotationProcessor {
    void process();

    void subscribe(StrategySpec<?> annotationStrategy);
}
