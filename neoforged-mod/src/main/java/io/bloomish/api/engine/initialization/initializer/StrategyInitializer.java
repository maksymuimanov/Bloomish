package io.bloomish.api.engine.initialization.initializer;

import io.bloomish.api.engine.context.ObjectRegistry;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;
import io.bloomish.api.engine.metadata.pool.SimpleStrategyPool;
import io.bloomish.api.engine.metadata.pool.StrategyPool;
import io.bloomish.api.engine.metadata.pool.StrategyScope;
import io.bloomish.api.engine.metadata.strategy.AnnotationStrategy;
import io.bloomish.api.util.ReflectionUtils;

import java.util.Collection;
import java.util.List;

public class StrategyInitializer implements ObjectRegistryInitializer {
    public static final String DEFAULT_CLASS_INJECTION = "default_class_injection";
    public static final String DEFAULT_CLASS_EVENT_LAYER = "default_class_event_layer";
    public static final String DEFAULT_CLASS_DATA = "default_class_data";
    public static final String DEFAULT_CLASS_CONFIG = "default_class_config";
    public static final String DEFAULT_FIELD_INJECTION = "default_field_injection";
    public static final String DEFAULT_FIELD_EVENT_BLOCK = "default_field_event_block";
    public static final String DEFAULT_FIELD_EVENT_CREATIVE = "default_field_event_creative";
    public static final String DEFAULT_FIELD_EVENT_FML = "default_field_event_fml";
    public static final String DEFAULT_FIELD_EVENT_RENDERER = "default_field_event_renderer";
    public static final String DEFAULT_FIELD_EVENT_PARTICLE = "default_field_event_particle";
    public static final String DEFAULT_FIELD_DATA = "default_field_data";
    public static final String DEFAULT_METHOD_INJECTION = "default_method_injection";
    public static final String DEFAULT_METHOD_EVENT_ATTRIBUTES = "default_method_event_attributes";
    public static final String DEFAULT_METHOD_DATA = "default_method_data";

    @Override
    public void initialize(Collection<Class<?>> classes, List<?> externalObjects, ObjectRegistry objectRegistry) {
        StrategyPool strategyPool = new SimpleStrategyPool();
        classes.stream()
                .filter(clazz -> clazz.isAnnotationPresent(Strategy.class))
                .sorted(ReflectionUtils.compareByAnnotationOverrideMethodPresence(Strategy.class))
                .forEach(clazz -> this.registerStrategy(clazz, strategyPool));
        objectRegistry.registerValue(strategyPool);
    }

    @SuppressWarnings("unchecked")
    private void registerStrategy(Class<?> clazz, StrategyPool strategyPool) {
        Strategy annotation = clazz.getDeclaredAnnotation(Strategy.class);
        this.validateStrategy(clazz);
        Class<? extends AnnotationStrategy<?, ?>> strategyClass = (Class<? extends AnnotationStrategy<?, ?>>) clazz;
        this.registerStrategy(strategyClass, strategyPool, annotation);
    }

    private void validateStrategy(Class<?> clazz) {
        if (!AnnotationStrategy.class.isAssignableFrom(clazz)) {
            throw new IllegalArgumentException("Strategy class " + clazz.getName() + " must be a subclass of AnnotationStrategy");
        }
    }

    @SuppressWarnings("unchecked")
    private void registerStrategy(Class<? extends AnnotationStrategy<?, ?>> strategyClass, StrategyPool strategyPool, Strategy annotation) {
        StrategyScope scope = new StrategyScope(annotation.value());
        if (!AnnotationStrategy.class.equals(annotation.override())) {
            strategyPool.override(scope, strategyClass, (Class<? extends AnnotationStrategy<?, ?>>) annotation.override());
        } else {
            strategyPool.put(scope, strategyClass);
        }
    }
}
