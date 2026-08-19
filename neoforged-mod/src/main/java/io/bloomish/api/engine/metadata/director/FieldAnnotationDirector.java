package io.bloomish.api.engine.metadata.director;

import io.bloomish.api.engine.metadata.pool.ProcessorPool;
import io.bloomish.api.engine.metadata.pool.SimpleProcessorPool;
import io.bloomish.api.engine.metadata.pool.SimpleStrategyPool;
import io.bloomish.api.engine.metadata.pool.StrategyPool;
import io.bloomish.api.engine.metadata.strategy.AnnotationStrategy;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class FieldAnnotationDirector implements AnnotationDirector {
    @Override
    public void direct(Class<?> clazz) throws Exception {
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            try {
                Annotation[] annotations = field.getDeclaredAnnotations();
                for (Annotation annotation : annotations) {
                    Class<? extends Annotation> annotationType = annotation.annotationType();
                    StrategyPool strategyPool = SimpleStrategyPool.getInstance();
                    var typeClass = Field.class;
                    if (!strategyPool.contains(annotationType, typeClass)) continue;
                    AnnotationStrategy<Field, ? extends Annotation> strategy = strategyPool.get(annotationType, typeClass);
                    ProcessorPool processorPool = SimpleProcessorPool.getInstance();
                    processorPool.subscribe(strategy, field);
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
