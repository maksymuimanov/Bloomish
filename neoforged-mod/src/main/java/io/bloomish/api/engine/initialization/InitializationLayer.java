package io.bloomish.api.engine.initialization;

import io.bloomish.api.ApiMod;
import io.bloomish.api.engine.EngineLayer;
import io.bloomish.api.engine.context.EngineContext;
import io.bloomish.api.engine.context.NeoMod;
import io.bloomish.api.engine.context.NeoModFactory;
import io.bloomish.api.engine.context.ObjectRegistry;
import io.bloomish.api.engine.initialization.initializer.ObjectPoolInitializer;
import io.bloomish.api.engine.initialization.scanner.ModClassScanner;
import io.bloomish.api.util.ReflectionUtils;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InitializationLayer implements EngineLayer {
    private Class<?> modClass;
    private List<ModClassScanner> classScanners;
    private List<ObjectPoolInitializer> objectPoolInitializers;
    private List<?> externalSource;

    @Override
    public void processAllTasks() {
        NeoMod mod = NeoModFactory.discover(this.modClass, this.classScanners);
        String modId = mod.modId();
        Set<Class<?>> classes = mod.classes();
        EngineContext.currentMod = mod;
        ApiMod.LOGGER.info("NeoMod dependency created: (modId={}, classes={})", modId, classes.size());
        Set<Class<?>> apiClasses = ReflectionUtils.getApiClasses();
        Set<Class<?>> initializationClasses = Stream.of(classes, apiClasses).flatMap(Set::stream).collect(Collectors.toSet());
        ApiMod.LOGGER.debug("Created classes set for initialization phase with dependency and api classes: (modId={}, classes={}, apiClasses={})", modId, classes.size(), apiClasses.size());
        ObjectRegistry objectRegistry = EngineContext.getInstance()
                .createRegistry(modId);
        ApiMod.LOGGER.debug("ObjectPool created for modId: {}", modId);
        objectPoolInitializers.forEach(initializer -> {
            ApiMod.LOGGER.debug("Running defaulted ObjectPoolInitializer - {}", initializer.getClass().getName());
            initializer.initialize(initializationClasses, this.externalSource, objectRegistry);
        });
        objectRegistry.getAll(ObjectPoolInitializer.class).forEach(initializer -> {
            ApiMod.LOGGER.debug("Running dynamic ObjectPoolInitializer - {}", initializer.getClass().getName());
            initializer.initialize(initializationClasses, this.externalSource, objectRegistry);
        });
    }

    public void setModClass(Class<?> modClass) {
        this.modClass = modClass;
    }

    public void setClassScanners(List<ModClassScanner> classScanners) {
        this.classScanners = classScanners;
    }

    public void setContextInitializers(List<ObjectPoolInitializer> objectPoolInitializers) {
        this.objectPoolInitializers = objectPoolInitializers;
    }

    public void setExternalSource(List<?> externalSource) {
        this.externalSource = externalSource;
    }
}
