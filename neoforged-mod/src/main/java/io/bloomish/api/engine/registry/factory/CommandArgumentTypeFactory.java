package io.bloomish.api.engine.registry.factory;

import io.bloomish.api.engine.context.DefaultObjectRegistry;
import io.bloomish.api.engine.registry.BloomishRegister;
import net.minecraft.commands.synchronization.ArgumentTypeInfo;

public class CommandArgumentTypeFactory extends AbstractObjectFactory<ArgumentTypeInfo<?, ?>> {
    public CommandArgumentTypeFactory() {
        this(DefaultObjectRegistry.getFromInstance("$CommandArgumentTypes"));
    }

    public CommandArgumentTypeFactory(BloomishRegister<ArgumentTypeInfo<?, ?>> register) {
        super(register);
    }
}
