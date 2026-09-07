package io.bloomish.api.metadata;

import java.util.Collection;

public interface AnnotationOrchestrator {
    void orchestrate(Collection<Class<?>> classes);
}
