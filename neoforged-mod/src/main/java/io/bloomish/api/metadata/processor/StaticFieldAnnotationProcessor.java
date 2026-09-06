package io.bloomish.api.metadata.processor;

import io.bloomish.api.bean.Bean;
import io.bloomish.api.metadata.executor.StaticFieldAnnotationExecutor;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Collection;

@Bean
public class StaticFieldAnnotationProcessor extends AbstractAnnotationProcessor<StaticFieldAnnotationExecutor<? super Annotation>> {
    public StaticFieldAnnotationProcessor(Collection<StaticFieldAnnotationExecutor<? super Annotation>> annotationExecutors) {
        super(annotationExecutors);
    }

    @Override
    public void process(Class<?> clazz) {
        for (Field field : clazz.getDeclaredFields()) {
            if (!Modifier.isStatic(field.getModifiers())) continue;
            this.runExecutors(field.getDeclaredAnnotations(), (annotation, executor) ->
                    executor.execute(annotation, field));
        }
    }
}
