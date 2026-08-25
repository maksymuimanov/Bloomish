package io.bloomish.api.engine.registry.factory;

import io.bloomish.api.engine.context.DefaultObjectRegistry;
import io.bloomish.api.engine.registry.BloomishRegister;
import net.minecraft.core.component.DataComponentType;

public class EnchantmentEffectComponentTypeFactory extends AbstractObjectFactory<DataComponentType<?>> {
    public EnchantmentEffectComponentTypeFactory() {
        this(DefaultObjectRegistry.getFromInstance("$EnchantmentEffectComponentTypes"));
    }

    public EnchantmentEffectComponentTypeFactory(BloomishRegister<DataComponentType<?>> register) {
        super(register);
    }
}
