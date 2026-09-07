package io.bloomish.api.initialization.initializer;

import io.bloomish.api.context.ObjectRegistry;
import net.minecraft.data.PackOutput;

import java.nio.file.Path;
import java.util.Collection;
import java.util.List;

public class PackOutputInitializer implements ObjectRegistryInitializer {
    private static final String PACK_OUTPUT_KEY = "$PackOutput";
    private static final Path GENERATED_RESOURCES_PATH = Path.of("src/generated/resources");

    @Override
    public void initialize(Collection<Class<?>> classes, List<?> externalObjects, ObjectRegistry registry) {
        Path outputPath = GENERATED_RESOURCES_PATH.toAbsolutePath().normalize();
        PackOutput packOutput = new PackOutput(outputPath);
        registry.registerValueByName(packOutput, PACK_OUTPUT_KEY);
    }
}