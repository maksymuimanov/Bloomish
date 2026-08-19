package io.bloomish.api.engine.metadata;

import io.bloomish.api.ApiMod;
import io.bloomish.api.engine.EngineLayer;
import io.bloomish.api.engine.context.EngineContext;
import io.bloomish.api.engine.metadata.consumer.AnnotationStrategyConsumer;
import io.bloomish.api.engine.metadata.consumer.AsyncStrategyConsumer;
import io.bloomish.api.engine.metadata.consumer.SimpleStrategyConsumer;
import io.bloomish.api.engine.metadata.director.AnnotationDirector;
import io.bloomish.api.engine.metadata.pool.ProcessorPool;
import io.bloomish.api.engine.metadata.pool.SimpleProcessorPool;

import java.util.Collection;
import java.util.List;
import java.util.Set;

public class MetadataLayer implements EngineLayer {
    public static final AnnotationStrategyConsumer SIMPLE_STRATEGY_CONSUMER = new SimpleStrategyConsumer();
    public static final AnnotationStrategyConsumer ASYNC_STRATEGY_CONSUMER = new AsyncStrategyConsumer();
    private List<AnnotationDirector> annotationDirectors;

    @Override
    public void process() {
        ApiMod.LOGGER.debug("Processing defaulted {} annotation directors", annotationDirectors.size());
        Set<Class<?>> classes = EngineContext.getModClasses();
        annotationDirectors.forEach(annotationDirector ->
                annotationDirector.directAll(classes));
        Collection<? extends AnnotationDirector> dynamicAnnotationDirectors = EngineContext.getObjects(AnnotationDirector.class);
        ApiMod.LOGGER.debug("Processing dynamic {} annotation directors", dynamicAnnotationDirectors.size());
        dynamicAnnotationDirectors.forEach(annotationDirector ->
                annotationDirector.directAll(classes));
        ProcessorPool processorPool = SimpleProcessorPool.getInstance();
        processorPool.processAll();
    }

    void setAnnotationDirectors(List<AnnotationDirector> annotationDirectors) {
        this.annotationDirectors = annotationDirectors;
    }
}
