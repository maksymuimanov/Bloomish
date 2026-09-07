package io.bloomish.api.metadata.processor;

import io.bloomish.api.bean.Bean;
import io.bloomish.api.context.ModContext;
import io.bloomish.api.metadata.executor.FieldAnnotationExecutor;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Collection;

@Bean
public class FieldAnnotationProcessor extends AbstractAnnotationProcessor<FieldAnnotationExecutor<? super Annotation>> {
    public FieldAnnotationProcessor(Collection<FieldAnnotationExecutor<? super Annotation>> fieldAnnotationExecutors) {
        super(fieldAnnotationExecutors);
    }

    @Override
    public void process(Class<?> clazz) {
        Object instance = ModContext.getObject(clazz).orElseThrow();
        for (Field field : clazz.getDeclaredFields()) {
            if (Modifier.isStatic(field.getModifiers())) continue;
            this.applyExecutors(field.getDeclaredAnnotations(), (annotation, executor) ->
                    executor.execute(annotation, field, instance));
        }
    }
}
