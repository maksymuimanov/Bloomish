package io.bloomish.api.engine.initialization.initializer;

import io.bloomish.api.engine.context.ObjectKey;
import io.bloomish.api.engine.context.ObjectRegistry;
import io.bloomish.api.engine.initialization.ObjectRegistryInitializer;
import io.bloomish.api.engine.metadata.annotation.injection.Injected;
import net.neoforged.fml.ModList;

import java.util.Collection;
import java.util.List;

public class InjectedInitializer implements ObjectRegistryInitializer {
    @Override
    public void initialize(Collection<Class<?>> classes, List<?> externalObjects, ObjectRegistry objectRegistry) {
        classes.forEach(clazz -> {
            if (!clazz.isAnnotationPresent(Injected.class)) return;
            Injected annotation = clazz.getDeclaredAnnotation(Injected.class);
            if (shouldRegister(annotation)) {
                registerBean(objectRegistry, clazz, annotation);
            }
        });
    }

    private boolean shouldRegister(Injected annotation) {
        String modCondition = annotation.mandatoryMod();
        return annotation.isContextObject() && (modCondition.isBlank() || ModList.get().isLoaded(modCondition));
    }

    private void registerBean(ObjectRegistry objectRegistry, Class<?> clazz, Injected annotation) {
        String beanName = annotation.value();
        if (beanName.isBlank()) {
            objectRegistry.registerValueByClass(clazz);
        } else {
            ObjectKey<?> objectKey = new ObjectKey<>(beanName, clazz);
            objectRegistry.registerValueByKey(objectKey);
        }
    }
}
