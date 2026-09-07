package io.bloomish.api.metadata.processor;

import io.bloomish.api.metadata.AnnotationExecutor;
import io.bloomish.api.metadata.AnnotationProcessor;
import io.bloomish.api.util.ReflectionUtils;

import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public abstract class AbstractAnnotationProcessor<E extends AnnotationExecutor<? extends Annotation>> implements AnnotationProcessor {
    private final Map<Class<? extends Annotation>, E> annotationExecutors;

    protected AbstractAnnotationProcessor(Collection<E> annotationExecutors) {
        this.annotationExecutors = annotationExecutors.stream()
                .collect(Collectors.toMap(AnnotationExecutor::annotationType, Function.identity()));
    }

    protected void applyExecutors(Annotation[] annotations, BiConsumer<Annotation, E> executorConsumer) {
        for (Annotation annotation : ReflectionUtils.extractDeepAnnotations(annotations)) {
            this.getAnnotationExecutor(annotation).ifPresent(executor ->
                    executorConsumer.accept(annotation, executor));
        }
    }

    protected Optional<E> getAnnotationExecutor(Annotation annotation) {
        return Optional.ofNullable(annotationExecutors.get(annotation.annotationType()));
    }
}
