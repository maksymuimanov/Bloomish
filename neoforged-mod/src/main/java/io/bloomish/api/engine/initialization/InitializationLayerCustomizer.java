package io.bloomish.api.engine.initialization;

import io.bloomish.api.engine.LayerCustomizer;
import io.bloomish.api.engine.initialization.initializer.*;
import io.bloomish.api.engine.initialization.scanner.ClasspathModClassScanner;
import io.bloomish.api.engine.initialization.scanner.ModClassScanner;

import java.util.List;

public class InitializationLayerCustomizer implements LayerCustomizer<InitializationLayer> {
    private static final List<ModClassScanner> DEFAULT_CLASS_SCANNERS = List.of(new ClasspathModClassScanner());
    private static final List<ObjectRegistryInitializer> DEFAULT_INITIALIZERS = List.of(new PackOutputInitializer(), new GsonInitializer(), new TemporalRegisterInitializer(), new FactoryInitializer(), new EventBusInitializer(), new ModContainerInitializer(), new InjectedInitializer(), new StrategyInitializer(), new ProcessorInitializer());
    private Class<?> modClass;
    private List<ModClassScanner> classScanners;
    private List<ObjectRegistryInitializer> initializers;
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

    public InitializationLayerCustomizer initializers(List<ObjectRegistryInitializer> initializers) {
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
        layer.setInitializers(this.initializers);
        layer.setExternalSource(this.externalSource);
    }
}
