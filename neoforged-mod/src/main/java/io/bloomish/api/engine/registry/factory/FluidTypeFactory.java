package io.bloomish.api.engine.registry.factory;

import io.bloomish.api.engine.context.InjectionPool;
import io.bloomish.api.engine.registry.TemporalRegister;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.registries.DeferredHolder;

public class FluidTypeFactory extends AbstractObjectFactory<FluidType> {
    public FluidTypeFactory() {
        this(InjectionPool.getFromInstance("$FluidTypes"));
    }

    public FluidTypeFactory(TemporalRegister<FluidType> register) {
        super(register);
    }

    public DeferredHolder<FluidType, FluidType> create(String name, FluidType.Properties properties) {
        return this.create(name, () -> new FluidType(properties));
    }
}