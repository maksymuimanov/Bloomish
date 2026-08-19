package io.bloomish.api.engine.initialization.scanner;

import io.bloomish.api.util.ReflectionUtils;
import net.neoforged.fml.ModList;
import net.neoforged.neoforgespi.language.ModFileScanData;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class ClasspathModClassScanner implements ModClassScanner {
    @Override
    public Set<Class<?>> scanClasses(String modId, Class<?> modClass) {
        return ModList.get()
                .getModFileById(modId)
                .getFile()
                .getScanResult()
                .getClasses()
                .stream()
                .map(ModFileScanData.ClassData::clazz)
                .map(clazz -> ReflectionUtils.forType(clazz, modClass))
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }
}
