package io.bloomish.api.engine.metadata.director;

import io.bloomish.api.engine.metadata.pool.ProcessorPool;
import io.bloomish.api.engine.metadata.pool.SimpleProcessorPool;
import io.bloomish.api.engine.metadata.pool.SimpleStrategyPool;
import io.bloomish.api.engine.metadata.pool.StrategyPool;
import io.bloomish.api.engine.metadata.strategy.AnnotationStrategy;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class MethodAnnotationDirector implements AnnotationDirector {
    @Override
    public void direct(Class<?> clazz) throws Exception {
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            try {
                Annotation[] annotations = method.getDeclaredAnnotations();
                for (Annotation annotation : annotations) {
                    Class<? extends Annotation> annotationType = annotation.annotationType();
                    StrategyPool strategyPool = SimpleStrategyPool.getInstance();
                    var typeClass = Method.class;
                    if (!strategyPool.contains(annotationType, typeClass)) continue;
                    AnnotationStrategy<Method, ? extends Annotation> strategy = strategyPool.get(annotationType, typeClass);
                    ProcessorPool processorPool = SimpleProcessorPool.getInstance();
                    processorPool.subscribe(strategy, method);
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
