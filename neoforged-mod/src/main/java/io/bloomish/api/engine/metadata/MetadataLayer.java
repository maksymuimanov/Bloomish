package io.bloomish.api.engine.metadata;

import io.bloomish.api.ApiMod;
import io.bloomish.api.context.ModContext;
import io.bloomish.api.engine.EngineLayer;
import io.bloomish.api.metadata.AnnotationOrchestrator;

import java.util.Collection;

public class MetadataLayer implements EngineLayer {
    @Override
    public void process() {
        Collection<Class<?>> classes = ModContext.getModClasses();
        ApiMod.LOGGER.debug("Running MetadataLayer for classes [{}]", classes.size());
        ModContext.forEachObject(AnnotationOrchestrator.class, annotationOrchestrator -> {
            ApiMod.LOGGER.debug("Running AnnotationOrchestrator: {}", annotationOrchestrator.getClass().getName());
            annotationOrchestrator.orchestrate(classes);
        });
    }
}
