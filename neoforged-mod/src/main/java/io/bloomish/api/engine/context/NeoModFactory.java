package io.bloomish.api.engine.context;

import io.bloomish.api.ApiMod;
import io.bloomish.api.engine.initialization.scanner.ModClassScanner;
import net.neoforged.fml.common.Mod;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public final class NeoModFactory {
    private NeoModFactory() {
    }

    public static NeoMod discover(Class<?> modClass, List<ModClassScanner> classScanners) {
        String modId = extractModId(modClass);
        ApiMod.LOGGER.info("Discovering mod classes for {} with modId: {}", modClass.getName(), modId);
        Set<Class<?>> classes = discoverClasses(modClass, classScanners, modId);
        String name = modClass.getSimpleName();
        ApiMod.LOGGER.info("Discovered {} for modId: {} (modName: {})", classes, modId, name);
        return new NeoMod(name, modClass, modId, classes);
    }

    private static String extractModId(Class<?> modClass) {
        Mod modAnnotation = modClass.getDeclaredAnnotation(Mod.class);
        if (modAnnotation == null) {
            throw new NeoModException("Missing @Mod annotation on " + modClass.getName());
        }
        return modAnnotation.value();
    }

    private static Set<Class<?>> discoverClasses(
            Class<?> modClass,
            List<ModClassScanner> classScanners,
            String modId
    ) {
        Set<Class<?>> classes = new LinkedHashSet<>();
        for (ModClassScanner scanner : classScanners) {
            try {
                ApiMod.LOGGER.debug("Running scanner {} for modId: {}", scanner.getClass().getName(), modId);
                Set<Class<?>> scannedClasses = scanner.scanClasses(modId, modClass);
                classes.addAll(scannedClasses);
            } catch (Exception e) {
                throw new NeoModException("Scanner %s failed to discover classes for modId: %s".formatted(scanner.getClass().getName(), modId), e);
            }
        }
        return classes;
    }
}
