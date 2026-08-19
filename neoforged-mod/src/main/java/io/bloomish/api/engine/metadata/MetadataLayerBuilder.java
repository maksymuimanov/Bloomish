package io.bloomish.api.engine.metadata;

import io.bloomish.api.engine.EngineBuilder;
import io.bloomish.api.engine.metadata.director.AnnotationDirector;
import io.bloomish.api.engine.metadata.director.ClassAnnotationDirector;
import io.bloomish.api.engine.metadata.director.FieldAnnotationDirector;
import io.bloomish.api.engine.metadata.director.MethodAnnotationDirector;

import java.util.List;

public class MetadataLayerBuilder {
    private static final List<AnnotationDirector> DEFAULT_ANNOTATION_DIRECTORS = List.of(new ClassAnnotationDirector(), new FieldAnnotationDirector(), new MethodAnnotationDirector());
    private final EngineBuilder engineBuilder;
    private final MetadataLayer metadataLayer;
    private List<AnnotationDirector> annotationDirectors = DEFAULT_ANNOTATION_DIRECTORS;

    public MetadataLayerBuilder(EngineBuilder engineBuilder) {
        this.engineBuilder = engineBuilder;
        this.metadataLayer = new MetadataLayer();
        this.engineBuilder.addLayer(this.metadataLayer);
    }

    public MetadataLayerBuilder annotationDirectors(List<AnnotationDirector> annotationDirectors) {
        this.annotationDirectors = annotationDirectors;
        return this;
    }

    public EngineBuilder and() {
        this.metadataLayer.setAnnotationDirectors(this.annotationDirectors);
        this.engineBuilder.processLayer(this.metadataLayer);
        return this.engineBuilder;
    }
}
