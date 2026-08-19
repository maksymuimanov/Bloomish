package io.bloomish.api.engine.registry.factory;

import io.bloomish.api.engine.context.DefaultObjectRegistry;
import io.bloomish.api.engine.registry.TemporalRegister;
import net.minecraft.world.level.material.Fluid;

public class FluidFactory extends AbstractObjectFactory<Fluid> {
    public FluidFactory() {
        this(DefaultObjectRegistry.getFromInstance("$Fluids"));
    }

    public FluidFactory(TemporalRegister<Fluid> register) {
        super(register);
    }
}