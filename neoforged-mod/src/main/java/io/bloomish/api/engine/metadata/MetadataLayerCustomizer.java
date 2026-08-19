package io.bloomish.api.engine.metadata;

import io.bloomish.api.engine.LayerCustomizer;
import io.bloomish.api.engine.metadata.director.AnnotationDirector;
import io.bloomish.api.engine.metadata.director.ClassAnnotationDirector;
import io.bloomish.api.engine.metadata.director.FieldAnnotationDirector;
import io.bloomish.api.engine.metadata.director.MethodAnnotationDirector;

import java.util.List;

public class MetadataLayerCustomizer implements LayerCustomizer<MetadataLayer> {
    private static final List<AnnotationDirector> DEFAULT_ANNOTATION_DIRECTORS = List.of(new ClassAnnotationDirector(), new FieldAnnotationDirector(), new MethodAnnotationDirector());
    private List<AnnotationDirector> annotationDirectors;

    public MetadataLayerCustomizer() {
        this.annotationDirectors = DEFAULT_ANNOTATION_DIRECTORS;
    }

    public MetadataLayerCustomizer annotationDirectors(List<AnnotationDirector> annotationDirectors) {
        this.annotationDirectors = annotationDirectors;
        return this;
    }

    @Override
    public void customize(MetadataLayer layer) {
        layer.setAnnotationDirectors(this.annotationDirectors);
    }
}
