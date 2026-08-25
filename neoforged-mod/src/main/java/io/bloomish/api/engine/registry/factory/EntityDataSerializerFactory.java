package io.bloomish.api.engine.registry.factory;

import io.bloomish.api.engine.context.DefaultObjectRegistry;
import io.bloomish.api.engine.registry.BloomishRegister;
import net.minecraft.network.syncher.EntityDataSerializer;

public class EntityDataSerializerFactory extends AbstractObjectFactory<EntityDataSerializer<?>> {
    public EntityDataSerializerFactory() {
        this(DefaultObjectRegistry.getFromInstance("$EntityDataSerializers"));
    }

    public EntityDataSerializerFactory(BloomishRegister<EntityDataSerializer<?>> register) {
        super(register);
    }
}
