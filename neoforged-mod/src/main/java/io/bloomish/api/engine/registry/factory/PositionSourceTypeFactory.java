package io.bloomish.api.engine.registry.factory;

import io.bloomish.api.engine.context.InjectionPool;
import io.bloomish.api.engine.registry.TemporalRegister;
import net.minecraft.world.level.gameevent.PositionSourceType;

public class PositionSourceTypeFactory extends AbstractObjectFactory<PositionSourceType<?>> {
    public PositionSourceTypeFactory() {
        this(InjectionPool.getFromInstance("$PositionSourceTypes"));
    }

    public PositionSourceTypeFactory(TemporalRegister<PositionSourceType<?>> register) {
        super(register);
    }
}
