package io.bloomish.api.metadata.executor;

import io.bloomish.api.metadata.AnnotationExecutor;

import java.lang.annotation.Annotation;

public interface TypeAnnotationExecutor<A extends Annotation> extends AnnotationExecutor<A> {
    void execute(A annotation, Class<?> clazz);
}
