package io.bloomish.api.engine.registry.factory;

import com.mojang.serialization.MapCodec;
import io.bloomish.api.engine.context.DefaultObjectRegistry;
import io.bloomish.api.engine.registry.TemporalRegister;
import net.minecraft.world.item.enchantment.LevelBasedValue;

public class EnchantmentLevelBasedValueTypeFactory extends AbstractObjectFactory<MapCodec<? extends LevelBasedValue>> {
    public EnchantmentLevelBasedValueTypeFactory() {
        this(DefaultObjectRegistry.getFromInstance("$EnchantmentLevelBasedValueTypes"));
    }

    public EnchantmentLevelBasedValueTypeFactory(TemporalRegister<MapCodec<? extends LevelBasedValue>> register) {
        super(register);
    }
}
