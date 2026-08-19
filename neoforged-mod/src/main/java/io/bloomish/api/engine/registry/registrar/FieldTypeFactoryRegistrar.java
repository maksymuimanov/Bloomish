package io.bloomish.api.engine.registry.registrar;

import io.bloomish.api.engine.context.DefaultObjectRegistry;
import io.bloomish.api.engine.context.EngineContext;
import io.bloomish.api.engine.registry.factory.ObjectFactory;
import io.bloomish.api.util.ReflectionUtils;
import net.neoforged.bus.api.IEventBus;

public class FieldTypeFactoryRegistrar implements FactoryRegistrar {
    @Override
    public void registerFactories(IEventBus eventBus) {
        EngineContext.currentMod.getClasses()
                .stream()
                .filter(ReflectionUtils::isFactoryPresent)
                .forEach(clazz -> {
                    ReflectionUtils.getStaticFieldTypeStream(clazz,
                                    field -> ObjectFactory.class.isAssignableFrom(field.getType()),
                                    type -> (ObjectFactory<?>) DefaultObjectRegistry.getFromInstance(type))
                            .forEach(factory -> factory.register(eventBus, clazz));
                });
    }
}
