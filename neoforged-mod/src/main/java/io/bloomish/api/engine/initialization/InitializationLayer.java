package io.bloomish.api.engine.initialization;

import io.bloomish.api.ApiMod;
import io.bloomish.api.engine.EngineLayer;
import io.bloomish.api.engine.context.*;
import io.bloomish.api.engine.initialization.initializer.ObjectRegistryInitializer;
import io.bloomish.api.engine.initialization.scanner.ModClassScanner;
import io.bloomish.api.util.ReflectionUtils;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InitializationLayer implements EngineLayer {
    private Class<?> modClass;
    private List<ModClassScanner> classScanners;
    private List<ObjectRegistryInitializer> initializers;
    private List<?> externalSource;

    @Override
    public void process() {
        EngineContext engineContext = EngineContext.getInstance();
        NeoMod mod = this.initializeMod(engineContext);
        Set<Class<?>> initializationClasses = this.aggregateClassesForInitialization(mod);
        ObjectRegistry objectRegistry = this.initializeObjectRegistry(engineContext, mod.modId());
        this.executeInitialization(initializationClasses, objectRegistry);
    }

    private NeoMod initializeMod(ModContext modContext) {
        NeoMod mod = NeoModFactory.discover(this.modClass, this.classScanners);
        modContext.setCurrentMod(mod);
        ApiMod.LOGGER.info("NeoMod dependency discovered: modId={}", mod.modId());
        return mod;
    }

    private Set<Class<?>> aggregateClassesForInitialization(NeoMod mod) {
        Set<Class<?>> classes = mod.classes();
        Set<Class<?>> apiClasses = ReflectionUtils.getApiClasses();
        Set<Class<?>> initializationClasses = Stream.of(classes, apiClasses)
                .flatMap(Set::stream)
                .collect(Collectors.toSet());
        ApiMod.LOGGER.debug("Received classes for initialization phase with dependency and api classes: [classes={}, apiClasses={}]", classes.size(), apiClasses.size());
        return initializationClasses;
    }

    private ObjectRegistry initializeObjectRegistry(ObjectRegistryContext<String> registryContext, String modId) {
        ObjectRegistry objectRegistry = registryContext.createRegistry(modId);
        registryContext.setCurrentRegistry(objectRegistry);
        ApiMod.LOGGER.debug("ObjectRegistry is initialized for modId: {}", modId);
        return objectRegistry;
    }

    private void executeInitialization(Set<Class<?>> initializationClasses, ObjectRegistry objectRegistry) {
        initializers.forEach(initializer -> {
            ApiMod.LOGGER.debug("Running defaulted ObjectPoolInitializer - {}", initializer.getClass().getName());
            initializer.initialize(initializationClasses, this.externalSource, objectRegistry);
        });
        objectRegistry.getAll(ObjectRegistryInitializer.class).forEach(initializer -> {
            ApiMod.LOGGER.debug("Running dynamic ObjectPoolInitializer - {}", initializer.getClass().getName());
            initializer.initialize(initializationClasses, this.externalSource, objectRegistry);
        });
    }

    void setModClass(Class<?> modClass) {
        this.modClass = modClass;
    }

    void setClassScanners(List<ModClassScanner> classScanners) {
        this.classScanners = classScanners;
    }

    void setInitializers(List<ObjectRegistryInitializer> objectRegistryInitializers) {
        this.initializers = objectRegistryInitializers;
    }

    void setExternalSource(List<?> externalSource) {
        this.externalSource = externalSource;
    }
}
