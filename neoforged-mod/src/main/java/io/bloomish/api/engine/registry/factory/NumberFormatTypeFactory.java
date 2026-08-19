package io.bloomish.api.engine.registry.factory;

import io.bloomish.api.engine.context.DefaultObjectRegistry;
import io.bloomish.api.engine.registry.TemporalRegister;
import net.minecraft.network.chat.numbers.NumberFormatType;

public class NumberFormatTypeFactory extends AbstractObjectFactory<NumberFormatType<?>> {
    public NumberFormatTypeFactory() {
        this(DefaultObjectRegistry.getFromInstance("$NumberFormatTypes"));
    }

    public NumberFormatTypeFactory(TemporalRegister<NumberFormatType<?>> register) {
        super(register);
    }
}
