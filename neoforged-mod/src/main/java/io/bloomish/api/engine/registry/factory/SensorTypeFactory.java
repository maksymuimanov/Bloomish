package io.bloomish.api.engine.registry.factory;

import io.bloomish.api.engine.context.DefaultObjectRegistry;
import io.bloomish.api.engine.registry.BloomishRegister;
import net.minecraft.world.entity.ai.sensing.SensorType;

public class SensorTypeFactory extends AbstractObjectFactory<SensorType<?>> {
    public SensorTypeFactory() {
        this(DefaultObjectRegistry.getFromInstance("$SensorTypes"));
    }

    public SensorTypeFactory(BloomishRegister<SensorType<?>> register) {
        super(register);
    }
}
