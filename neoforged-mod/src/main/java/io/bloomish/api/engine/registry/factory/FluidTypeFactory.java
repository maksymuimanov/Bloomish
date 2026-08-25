package io.bloomish.api.engine.registry.factory;

import io.bloomish.api.engine.context.DefaultObjectRegistry;
import io.bloomish.api.engine.registry.BloomishRegister;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.registries.DeferredHolder;

public class FluidTypeFactory extends AbstractObjectFactory<FluidType> {
    public FluidTypeFactory() {
        this(DefaultObjectRegistry.getFromInstance("$FluidTypes"));
    }

    public FluidTypeFactory(BloomishRegister<FluidType> register) {
        super(register);
    }

    public DeferredHolder<FluidType, FluidType> create(String name, FluidType.Properties properties) {
        return this.create(name, () -> new FluidType(properties));
    }
}