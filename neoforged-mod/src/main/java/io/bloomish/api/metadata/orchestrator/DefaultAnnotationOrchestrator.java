package io.bloomish.api.metadata.orchestrator;

import io.bloomish.api.bean.Bean;
import io.bloomish.api.metadata.AnnotationOrchestrator;
import io.bloomish.api.metadata.AnnotationProcessor;

import java.util.Collection;

@Bean
public class DefaultAnnotationOrchestrator implements AnnotationOrchestrator {
    private final Iterable<AnnotationProcessor> annotationProcessors;

    public DefaultAnnotationOrchestrator(Iterable<AnnotationProcessor> annotationProcessors) {
        this.annotationProcessors = annotationProcessors;
    }

    @Override
    public void orchestrate(Collection<Class<?>> classes) {
        classes.parallelStream().forEach(clazz ->
                annotationProcessors.forEach(annotationProcessor ->
                        annotationProcessor.process(clazz)));
    }
}
