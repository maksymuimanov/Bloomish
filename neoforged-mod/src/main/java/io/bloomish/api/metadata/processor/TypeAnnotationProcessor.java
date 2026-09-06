package io.bloomish.api.metadata.processor;

import io.bloomish.api.bean.Bean;
import io.bloomish.api.metadata.executor.TypeAnnotationExecutor;

import java.lang.annotation.Annotation;
import java.util.Collection;

@Bean
public class TypeAnnotationProcessor extends AbstractAnnotationProcessor<TypeAnnotationExecutor<? super Annotation>> {
    public TypeAnnotationProcessor(Collection<TypeAnnotationExecutor<? super Annotation>> annotationExecutors) {
        super(annotationExecutors);
    }

    @Override
    public void process(Class<?> clazz) {
        this.runExecutors(clazz.getDeclaredAnnotations(), (annotation, executor) ->
                executor.execute(annotation, clazz));
    }
}
