package io.bloomish.api.engine.initialization;

import io.bloomish.api.engine.LayerCustomizer;
import io.bloomish.api.engine.initialization.initializer.*;
import io.bloomish.api.engine.initialization.scanner.ClasspathModClassScanner;
import io.bloomish.api.engine.initialization.scanner.ModClassScanner;

import java.util.List;

public class InitializationLayerCustomizer implements LayerCustomizer<InitializationLayer> {
    private static final List<ModClassScanner> DEFAULT_CLASS_SCANNERS = List.of(new ClasspathModClassScanner());
    private static final List<ObjectPoolInitializer> DEFAULT_INITIALIZERS = List.of(new TemporalRegisterPoolInitializer(), new FactoryPoolInitializer(), new EventBusPoolInitializer(), new ModContainerPoolInitializer(), new InjectedObjectPoolInitializer(), new StrategyPoolInitializer(), new HandlerPoolInitializer(), new ProcessorPoolInitializer());
    private Class<?> modClass;
    private List<ModClassScanner> classScanners;
    private List<ObjectPoolInitializer> initializers;
    private List<?> externalSource;

    public InitializationLayerCustomizer() {
        this.classScanners = DEFAULT_CLASS_SCANNERS;
        this.initializers = DEFAULT_INITIALIZERS;
    }

    public InitializationLayerCustomizer modClass(Class<?> modClass) {
        this.modClass = modClass;
        return this;
    }

    public InitializationLayerCustomizer classScanners(List<ModClassScanner> classScanners) {
        this.classScanners = classScanners;
        return this;
    }

    public InitializationLayerCustomizer initializers(List<ObjectPoolInitializer> initializers) {
        this.initializers = initializers;
        return this;
    }

    public InitializationLayerCustomizer externalSource(List<?> externalSource) {
        this.externalSource = externalSource;
        return this;
    }

    @Override
    public void customize(InitializationLayer layer) {
        layer.setModClass(this.modClass);
        layer.setClassScanners(this.classScanners);
        layer.setContextInitializers(this.initializers);
        layer.setExternalSource(this.externalSource);
    }
}
