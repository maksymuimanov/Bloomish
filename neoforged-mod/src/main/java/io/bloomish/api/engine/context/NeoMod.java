package io.bloomish.api.engine.context;

import io.bloomish.api.ApiMod;
import io.bloomish.api.engine.initialization.scanner.ModClassScanner;
import net.neoforged.fml.common.Mod;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.StringJoiner;

public class NeoMod {
    private String name;
    private Class<?> clazz;
    private String modId;
    private Set<Class<?>> classes;

    public static NeoMod discover(Class<?> clazz, List<ModClassScanner> classScanners) {
        String modId = extractModId(clazz);
        ApiMod.LOGGER.info("Creating NeoMod instance for class={} with modId={}", clazz.getName(), modId);
        Set<Class<?>> classes = new LinkedHashSet<>();
        gatherClassesForMod(clazz, classScanners, modId, classes);
        String name = clazz.getSimpleName();
        ApiMod.LOGGER.info("Discovered {} for modId: {} (modName: {})", classes, modId, name);
        return new NeoMod(name, clazz, modId, classes);
    }

    private static String extractModId(Class<?> clazz) {
        Mod modAnnotation = clazz.getDeclaredAnnotation(Mod.class);
        if (modAnnotation == null) {
            throw new IllegalArgumentException("Missing @Mod annotation on " + clazz.getName());
        }
        return modAnnotation.value();
    }

    private static void gatherClassesForMod(
            Class<?> clazz,
            List<ModClassScanner> classScanners,
            String modId,
            Set<Class<?>> classes
    ) {
        for (ModClassScanner scanner : classScanners) {
            try {
                ApiMod.LOGGER.debug("Running ModClassScanner: {} for modId: {}", scanner.getClass().getName(), modId);
                scanner.getClasses(modId, clazz, classes);
            } catch (Exception e) {
                ApiMod.LOGGER.error("Scanner {} failed while processing modId - {}: {}", scanner.getClass().getName(), modId, e.getMessage(), e);
                throw new RuntimeException(e);
            }
        }
    }

    private NeoMod(String name, Class<?> clazz, String modId, Set<Class<?>> classes) {
        this.name = name;
        this.clazz = clazz;
        this.modId = modId;
        this.classes = classes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Class<?> getClazz() {
        return clazz;
    }

    public void setClazz(Class<?> clazz) {
        this.clazz = clazz;
    }

    public String getModId() {
        return modId;
    }

    public void setModId(String modId) {
        this.modId = modId;
    }

    public Set<Class<?>> getClasses() {
        return classes;
    }

    public void setClasses(Set<Class<?>> classes) {
        this.classes = classes;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", NeoMod.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .add("clazz=" + clazz)
                .add("modId='" + modId + "'")
                .add("classes=" + classes)
                .toString();
    }
}
