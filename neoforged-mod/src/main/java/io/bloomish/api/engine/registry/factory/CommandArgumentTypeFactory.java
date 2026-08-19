package io.bloomish.api.engine.registry.factory;

import io.bloomish.api.engine.context.InjectionPool;
import io.bloomish.api.engine.registry.TemporalRegister;
import net.minecraft.commands.synchronization.ArgumentTypeInfo;

public class CommandArgumentTypeFactory extends AbstractObjectFactory<ArgumentTypeInfo<?, ?>> {
    public CommandArgumentTypeFactory() {
        this(InjectionPool.getFromInstance("$CommandArgumentTypes"));
    }

    public CommandArgumentTypeFactory(TemporalRegister<ArgumentTypeInfo<?, ?>> register) {
        super(register);
    }
}
