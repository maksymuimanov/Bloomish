package io.bloomish.api.engine.registry.registrar;

import io.bloomish.api.engine.context.InjectionPool;
import io.bloomish.api.engine.context.ModContext;
import io.bloomish.api.engine.registry.factory.ObjectFactory;
import io.bloomish.api.util.ReflectionUtils;
import net.neoforged.bus.api.IEventBus;

public class FieldTypeFactoryRegistrar implements FactoryRegistrar {
    @Override
    public void registerFactories(IEventBus eventBus) {
        ModContext.NEO_MOD.getClasses()
                .stream()
                .filter(ReflectionUtils::isFactoryPresent)
                .forEach(clazz -> {
                    ReflectionUtils.getStaticFieldTypeStream(clazz,
                                    field -> ObjectFactory.class.isAssignableFrom(field.getType()),
                                    type -> (ObjectFactory<?>) InjectionPool.getFromInstance(type))
                            .forEach(factory -> factory.register(eventBus, clazz));
                });
    }
}
