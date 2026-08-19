package io.bloomish.api.engine.metadata.director;

import io.bloomish.api.engine.metadata.pool.ProcessorPool;
import io.bloomish.api.engine.metadata.pool.SimpleProcessorPool;
import io.bloomish.api.engine.metadata.pool.SimpleStrategyPool;
import io.bloomish.api.engine.metadata.pool.StrategyPool;
import io.bloomish.api.engine.metadata.strategy.AnnotationStrategy;

import java.lang.annotation.Annotation;

public class ClassAnnotationDirector implements AnnotationDirector {
    @Override
    public void direct(Class<?> clazz) throws Exception {
        try {
            Annotation[] annotations = clazz.getDeclaredAnnotations();
            for (Annotation annotation : annotations) {
                Class<? extends Annotation> annotationType = annotation.annotationType();
                StrategyPool strategyPool = SimpleStrategyPool.getInstance();
                var typeClass = Class.class;
                if (!strategyPool.contains(annotationType, typeClass)) continue;
                AnnotationStrategy<Class<?>, ? extends Annotation> strategy = strategyPool.get(annotationType, typeClass);
                ProcessorPool processorPool = SimpleProcessorPool.getInstance();
                processorPool.subscribe(strategy, clazz);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
