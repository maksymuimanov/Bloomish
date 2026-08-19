package io.bloomish.api.engine.initialization.initializer;

import io.bloomish.api.engine.context.ObjectRegistry;
import io.bloomish.api.engine.metadata.annotation.injection.Injected;
import net.neoforged.fml.ModList;

import java.util.Collection;
import java.util.List;

public class InjectedObjectPoolInitializer implements ObjectPoolInitializer {
    @Override
    public void initialize(Collection<Class<?>> classes, List<?> externalObjects, ObjectRegistry objectRegistry) {
        classes.forEach(clazz -> {
            if (!clazz.isAnnotationPresent(Injected.class)) return;
            Injected annotation = clazz.getDeclaredAnnotation(Injected.class);
            String modCondition = annotation.mandatoryMod();
            if (annotation.isContextObject() && (modCondition.isBlank() || ModList.get().isLoaded(modCondition))) {
                String beanName = annotation.value();
                if (beanName.isBlank()) {
                    objectRegistry.register(clazz);
                } else {
                    objectRegistry.register(beanName, clazz);
                }
            }
        });
    }
}
