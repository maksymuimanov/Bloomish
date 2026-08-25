package io.bloomish.api.engine.initialization.initializer;

import io.bloomish.api.engine.context.ObjectRegistry;
import io.bloomish.api.engine.initialization.ObjectRegistryInitializer;
import net.minecraft.data.PackOutput;

import java.nio.file.Path;
import java.util.Collection;
import java.util.List;

public class PackOutputInitializer implements ObjectRegistryInitializer {
    private static final String PACK_OUTPUT_KEY = "$PackOutput";
    private static final Path GENERATED_RESOURCES_PATH = Path.of("src/generated/resources");

    @Override
    public void initialize(Collection<Class<?>> classes, List<?> externalObjects, ObjectRegistry objectRegistry) {
        Path outputPath = GENERATED_RESOURCES_PATH.toAbsolutePath().normalize();
        PackOutput packOutput = new PackOutput(outputPath);
        objectRegistry.registerValueByName(packOutput, PACK_OUTPUT_KEY);
    }
}