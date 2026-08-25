package io.bloomish.api.engine.initialization.initializer;

import io.bloomish.api.engine.context.ObjectKey;
import io.bloomish.api.engine.context.ObjectRegistry;
import io.bloomish.api.engine.initialization.ObjectRegistryInitializer;
import io.bloomish.api.engine.metadata.annotation.injection.Injected;
import io.bloomish.api.engine.metadata.annotation.injection.OnMod;
import net.neoforged.fml.ModList;

import java.util.Collection;
import java.util.List;

public class InjectedInitializer implements ObjectRegistryInitializer {
    @Override
    public void initialize(Collection<Class<?>> classes, List<?> externalObjects, ObjectRegistry objectRegistry) {
        classes.forEach(clazz -> {
            if (!clazz.isAnnotationPresent(Injected.class)) return;
            Injected annotation = clazz.getDeclaredAnnotation(Injected.class);
            if (shouldRegister(clazz, annotation)) {
                registerBean(objectRegistry, clazz, annotation);
            }
        });
    }

    private boolean shouldRegister(Class<?> clazz, Injected annotation) {
        boolean result = annotation.shouldInject();
        if (clazz.isAnnotationPresent(OnMod.class)) {
            boolean isModLoaded = this.checkModIsLoaded(clazz);
            result = result && isModLoaded;
        }
        return result;
    }

    private boolean checkModIsLoaded(Class<?> clazz) {
        OnMod onMod = clazz.getAnnotation(OnMod.class);
        String modName = onMod.value();
        return ModList.get().isLoaded(modName);
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
