package io.bloomish.api.engine.initialization.scanner;

import java.util.Set;

public interface ModClassScanner {
    Set<Class<?>> scanClasses(String modId, Class<?> modClass);
}
