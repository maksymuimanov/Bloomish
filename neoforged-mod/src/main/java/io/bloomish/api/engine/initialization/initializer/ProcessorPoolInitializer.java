package io.bloomish.api.engine.initialization.initializer;

import io.bloomish.api.engine.context.ObjectPool;
import io.bloomish.api.engine.metadata.annotation.injection.Processor;
import io.bloomish.api.engine.metadata.pool.ProcessorPool;
import io.bloomish.api.engine.metadata.pool.ProcessorScope;
import io.bloomish.api.engine.metadata.pool.SimpleProcessorPool;
import io.bloomish.api.engine.metadata.processor.AnnotationProcessor;
import io.bloomish.api.core.util.ReflectionUtils;

import java.util.Collection;
import java.util.List;

public class ProcessorPoolInitializer implements ObjectPoolInitializer {
    @Override
    @SuppressWarnings("unchecked")
    public void initialize(Collection<Class<?>> classes, List<?> externalObjects, ObjectPool objectPool) {
        ProcessorPool processorPool = new SimpleProcessorPool();
        classes.stream()
                .filter(clazz -> clazz.isAnnotationPresent(Processor.class))
                .sorted(ReflectionUtils.compareByAnnotationOverrideMethodPresence(Processor.class))
                .forEach(clazz -> {
                    Processor annotation = clazz.getDeclaredAnnotation(Processor.class);
                    ProcessorScope scope = new ProcessorScope(annotation.value());
                    if (!AnnotationProcessor.class.equals(annotation.override())) {
                        processorPool.override(scope, annotation.override());
                    } else {
                        processorPool.put(scope, (Class<? extends AnnotationProcessor>) clazz);
                    }
                });
        objectPool.put(processorPool);
    }
}
