package io.bloomish.api.metadata;

import java.lang.annotation.Annotation;

public interface AnnotationExecutor<A extends Annotation> {
    Class<A> annotationType();
}
