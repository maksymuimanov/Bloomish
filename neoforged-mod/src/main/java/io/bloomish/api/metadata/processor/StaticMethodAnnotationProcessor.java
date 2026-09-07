package io.bloomish.api.metadata.processor;

import io.bloomish.api.bean.Bean;
import io.bloomish.api.metadata.executor.StaticMethodAnnotationExecutor;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Collection;

@Bean
public class StaticMethodAnnotationProcessor extends AbstractAnnotationProcessor<StaticMethodAnnotationExecutor<? super Annotation>> {
    public StaticMethodAnnotationProcessor(Collection<StaticMethodAnnotationExecutor<? super Annotation>> annotationExecutors) {
        super(annotationExecutors);
    }

    @Override
    public void process(Class<?> clazz) {
        for (Method method : clazz.getDeclaredMethods()) {
            if (!Modifier.isStatic(method.getModifiers())) continue;
            this.applyExecutors(method.getDeclaredAnnotations(), (annotation, executor) ->
                    executor.execute(annotation, method));
        }
    }
}
