package io.bloomish.api.engine.registry.factory;

import io.bloomish.api.engine.context.InjectionPool;
import io.bloomish.api.engine.registry.TemporalRegister;
import net.neoforged.neoforge.registries.holdersets.HolderSetType;

public class HolderSetTypeFactory extends AbstractObjectFactory<HolderSetType> {
    public HolderSetTypeFactory() {
        this(InjectionPool.getFromInstance("$HolderSetTypes"));
    }

    public HolderSetTypeFactory(TemporalRegister<HolderSetType> register) {
        super(register);
    }
}
