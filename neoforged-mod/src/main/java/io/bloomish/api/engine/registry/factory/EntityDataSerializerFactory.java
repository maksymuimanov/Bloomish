package io.bloomish.api.engine.registry.factory;

import io.bloomish.api.engine.context.InjectionPool;
import io.bloomish.api.engine.registry.TemporalRegister;
import net.minecraft.network.syncher.EntityDataSerializer;

public class EntityDataSerializerFactory extends AbstractObjectFactory<EntityDataSerializer<?>> {
    public EntityDataSerializerFactory() {
        this(InjectionPool.getFromInstance("$EntityDataSerializers"));
    }

    public EntityDataSerializerFactory(TemporalRegister<EntityDataSerializer<?>> register) {
        super(register);
    }
}
