package io.bloomish.api.engine.initialization.initializer;

import io.bloomish.api.engine.context.ObjectRegistry;
import io.bloomish.api.engine.event.EventHandler;
import io.bloomish.api.engine.event.pool.HandlerPool;
import io.bloomish.api.engine.event.pool.SimpleHandlerPool;
import io.bloomish.api.engine.metadata.annotation.injection.Handler;
import io.bloomish.api.util.ReflectionUtils;

import java.util.Collection;
import java.util.List;

public class HandlerInitializer implements ObjectRegistryInitializer {
    @Override
    public void initialize(Collection<Class<?>> classes, List<?> externalObjects, ObjectRegistry objectRegistry) {
        HandlerPool handlerPool = new SimpleHandlerPool();
        classes.stream()
                .filter(clazz -> clazz.isAnnotationPresent(Handler.class))
                .sorted(ReflectionUtils.compareByAnnotationOverrideMethodPresence(Handler.class))
                .forEach(clazz -> this.registerHandler(clazz, handlerPool));
        objectRegistry.registerValue(handlerPool);
    }

    private void registerHandler(Class<?> clazz, HandlerPool handlerPool) {
        Handler annotation = clazz.getDeclaredAnnotation(Handler.class);
        this.validateEventHandler(clazz);
        Class<? extends EventHandler> eventHandlerClass = clazz.asSubclass(EventHandler.class);
        this.registerHandler(handlerPool, annotation, eventHandlerClass);
    }

    private void validateEventHandler(Class<?> clazz) {
        if (!EventHandler.class.isAssignableFrom(clazz)) {
            throw new ObjectRegistryInitializerException("Handler " + clazz.getName() + " must be a subclass of EventHandler");
        }
    }

    private void registerHandler(
            HandlerPool handlerPool,
            Handler annotation,
            Class<? extends EventHandler> eventHandlerClass
    ) {
        if (!EventHandler.class.equals(annotation.override())) {
            handlerPool.override(annotation.value(), annotation.override(), eventHandlerClass);
        } else {
            handlerPool.put(annotation.value(), eventHandlerClass);
        }
    }
}
