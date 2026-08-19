package io.bloomish.api.engine.initialization.scanner;

import io.bloomish.api.engine.metadata.annotation.injection.Handler;
import io.bloomish.api.engine.metadata.annotation.injection.Injected;
import io.bloomish.api.engine.metadata.annotation.injection.Strategy;
import io.bloomish.api.util.ReflectionUtils;
import net.neoforged.fml.ModList;
import net.neoforged.neoforgespi.language.ModFileScanData;
import org.objectweb.asm.Type;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class AnnotatedModClassScanner implements ModClassScanner {
    @Override
    public Set<Class<?>> scanClasses(String modId, Class<?> modClass) {
        return ModList.get()
                .getModFileById(modId)
                .getFile()
                .getScanResult()
                .getAnnotations()
                .stream()
                .filter(this::isAnnotated)
                .map(ModFileScanData.AnnotationData::clazz)
                .map(clazz -> ReflectionUtils.forType(clazz, modClass))
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    private boolean isAnnotated(ModFileScanData.AnnotationData annotation) {
        Type annotationType = annotation.annotationType();
        return annotationType.equals(Type.getType(Injected.class))
                || annotationType.equals(Type.getType(Strategy.class))
                || annotationType.equals(Type.getType(Handler.class));
    }
}
