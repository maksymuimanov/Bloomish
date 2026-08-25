package io.bloomish.api.engine.registry.factory;

import io.bloomish.api.engine.context.DefaultObjectRegistry;
import io.bloomish.api.engine.registry.BloomishRegister;
import net.minecraft.world.level.gameevent.PositionSourceType;

public class PositionSourceTypeFactory extends AbstractObjectFactory<PositionSourceType<?>> {
    public PositionSourceTypeFactory() {
        this(DefaultObjectRegistry.getFromInstance("$PositionSourceTypes"));
    }

    public PositionSourceTypeFactory(BloomishRegister<PositionSourceType<?>> register) {
        super(register);
    }
}
