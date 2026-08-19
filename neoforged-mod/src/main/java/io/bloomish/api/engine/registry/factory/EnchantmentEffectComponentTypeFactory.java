package io.bloomish.api.engine.registry.factory;

import io.bloomish.api.engine.context.DefaultObjectRegistry;
import io.bloomish.api.engine.registry.TemporalRegister;
import net.minecraft.core.component.DataComponentType;

public class EnchantmentEffectComponentTypeFactory extends AbstractObjectFactory<DataComponentType<?>> {
    public EnchantmentEffectComponentTypeFactory() {
        this(DefaultObjectRegistry.getFromInstance("$EnchantmentEffectComponentTypes"));
    }

    public EnchantmentEffectComponentTypeFactory(TemporalRegister<DataComponentType<?>> register) {
        super(register);
    }
}
