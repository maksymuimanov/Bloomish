package io.bloomish.api.context;

import java.util.Collection;

public interface ClassContext {
    Collection<Class<?>> getAllClasses();

    void addAllClasses(Collection<Class<?>> classes);
}
