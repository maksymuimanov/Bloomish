package io.bloomish.api.engine.registry.factory;

import io.bloomish.api.engine.context.InjectionPool;
import io.bloomish.api.engine.registry.TemporalRegister;
import net.minecraft.world.level.material.Fluid;

public class FluidFactory extends AbstractObjectFactory<Fluid> {
    public FluidFactory() {
        this(InjectionPool.getFromInstance("$Fluids"));
    }

    public FluidFactory(TemporalRegister<Fluid> register) {
        super(register);
    }
}