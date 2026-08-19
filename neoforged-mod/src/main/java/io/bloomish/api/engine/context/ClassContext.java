package io.bloomish.api.engine.context;

import java.util.Collection;

public interface ClassContext {
    Collection<Class<?>> getAllClasses();

    void addAllClasses(Collection<Class<?>> classes);
}
