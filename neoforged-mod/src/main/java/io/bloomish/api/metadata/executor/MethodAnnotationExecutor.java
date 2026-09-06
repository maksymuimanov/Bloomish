package io.bloomish.api.metadata.executor;

import io.bloomish.api.metadata.AnnotationExecutor;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public interface MethodAnnotationExecutor<A extends Annotation> extends AnnotationExecutor<A> {
    void execute(A annotation, Method method, Object bean);
}
