package io.bloomish.api.engine.registry.factory;

import io.bloomish.api.engine.context.InjectionPool;
import io.bloomish.api.engine.registry.TemporalRegister;
import net.minecraft.world.entity.ai.sensing.SensorType;

public class SensorTypeFactory extends AbstractObjectFactory<SensorType<?>> {
    public SensorTypeFactory() {
        this(InjectionPool.getFromInstance("$SensorTypes"));
    }

    public SensorTypeFactory(TemporalRegister<SensorType<?>> register) {
        super(register);
    }
}
