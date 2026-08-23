package io.bloomish.api.engine.initialization.initializer;

import com.google.gson.Gson;
import io.bloomish.api.engine.context.ObjectRegistry;

import java.util.Collection;
import java.util.List;

public class GsonInitializer implements ObjectRegistryInitializer {
    private static final String GSON_KEY = "$Gson";

    @Override
    public void initialize(Collection<Class<?>> classes, List<?> externalObjects, ObjectRegistry objectRegistry) {
        objectRegistry.registerValueByName(new Gson(), GSON_KEY);
    }
}