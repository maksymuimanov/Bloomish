package io.bloomish.api.engine.initialization.initializer;

import io.bloomish.api.engine.context.ObjectRegistry;
import io.bloomish.api.engine.metadata.annotation.injection.Processor;
import io.bloomish.api.engine.metadata.pool.ProcessorPool;
import io.bloomish.api.engine.metadata.pool.ProcessorScope;
import io.bloomish.api.engine.metadata.pool.SimpleProcessorPool;
import io.bloomish.api.engine.metadata.processor.AnnotationProcessor;
import io.bloomish.api.util.ReflectionUtils;

import java.util.Collection;
import java.util.List;

public class ProcessorInitializer implements ObjectRegistryInitializer {
    @Override
    public void initialize(Collection<Class<?>> classes, List<?> externalObjects, ObjectRegistry objectRegistry) {
        ProcessorPool processorPool = new SimpleProcessorPool();
        classes.stream()
                .filter(clazz -> clazz.isAnnotationPresent(Processor.class))
                .sorted(ReflectionUtils.compareByAnnotationOverrideMethodPresence(Processor.class))
                .forEach(clazz -> this.registerProcessor(clazz, processorPool));
        objectRegistry.registerValue(processorPool);
    }

    private void registerProcessor(Class<?> clazz, ProcessorPool processorPool) {
        Processor annotation = clazz.getDeclaredAnnotation(Processor.class);
        this.validateProcessor(clazz);
        this.registerProcessor(clazz, processorPool, annotation);
    }

    private void validateProcessor(Class<?> clazz) {
        if (!AnnotationProcessor.class.isAssignableFrom(clazz)) {
            throw new ObjectRegistryInitializerException("Processor " + clazz.getName() + " must be a subclass of AnnotationProcessor");
        }
    }

    private void registerProcessor(Class<?> clazz, ProcessorPool processorPool, Processor annotation) {
        ProcessorScope scope = new ProcessorScope(annotation.value());
        if (!AnnotationProcessor.class.equals(annotation.override())) {
            processorPool.override(scope, annotation.override());
        } else {
            processorPool.put(scope, clazz.asSubclass(AnnotationProcessor.class));
        }
    }
}
