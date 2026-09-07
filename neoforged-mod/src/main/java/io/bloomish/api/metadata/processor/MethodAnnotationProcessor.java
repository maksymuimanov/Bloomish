package io.bloomish.api.metadata.processor;

import io.bloomish.api.bean.Bean;
import io.bloomish.api.context.ModContext;
import io.bloomish.api.metadata.executor.MethodAnnotationExecutor;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Collection;

@Bean
public class MethodAnnotationProcessor extends AbstractAnnotationProcessor<MethodAnnotationExecutor<? super Annotation>> {
    public MethodAnnotationProcessor(Collection<MethodAnnotationExecutor<? super Annotation>> annotationExecutors) {
        super(annotationExecutors);
    }

    @Override
    public void process(Class<?> clazz) {
        Object instance = ModContext.getObject(clazz).orElseThrow();
        for (Method method : clazz.getDeclaredMethods()) {
            if (Modifier.isStatic(method.getModifiers())) continue;
            this.applyExecutors(method.getDeclaredAnnotations(), (annotation, executor) ->
                    executor.execute(annotation, method, instance));
        }
    }
}
