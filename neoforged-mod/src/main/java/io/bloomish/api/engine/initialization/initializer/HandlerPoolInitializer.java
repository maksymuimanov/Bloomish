package io.bloomish.api.engine.initialization.initializer;

import io.bloomish.api.engine.context.ObjectPool;
import io.bloomish.api.engine.event.handler.EventHandler;
import io.bloomish.api.engine.event.pool.HandlerPool;
import io.bloomish.api.engine.event.pool.SimpleHandlerPool;
import io.bloomish.api.engine.metadata.annotation.injection.Handler;
import io.bloomish.api.core.util.ReflectionUtils;

import java.util.Collection;
import java.util.List;

public class HandlerPoolInitializer implements ObjectPoolInitializer {
    @Override
    @SuppressWarnings("unchecked")
    public void initialize(Collection<Class<?>> classes, List<?> externalObjects, ObjectPool objectPool) {
        HandlerPool handlerPool = new SimpleHandlerPool();
        classes.stream()
                .filter(clazz -> clazz.isAnnotationPresent(Handler.class))
                .sorted(ReflectionUtils.compareByAnnotationOverrideMethodPresence(Handler.class))
                .forEach(clazz -> {
                    Handler annotation = clazz.getDeclaredAnnotation(Handler.class);
                    Class<? extends EventHandler> eventHandlerClass = (Class<? extends EventHandler>) clazz;
                    if (!EventHandler.class.equals(annotation.override())) {
                        handlerPool.override(annotation.value(), annotation.override(), eventHandlerClass);
                    } else {
                        handlerPool.put(annotation.value(), eventHandlerClass);
                    }
                });
        objectPool.put(handlerPool);
    }
}
