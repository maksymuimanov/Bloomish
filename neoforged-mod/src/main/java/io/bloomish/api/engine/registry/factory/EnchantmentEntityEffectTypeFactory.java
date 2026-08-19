package io.bloomish.api.engine.registry.factory;

import com.mojang.serialization.MapCodec;
import io.bloomish.api.engine.context.DefaultObjectRegistry;
import io.bloomish.api.engine.registry.TemporalRegister;
import net.minecraft.world.item.enchantment.effects.EnchantmentEntityEffect;

public class EnchantmentEntityEffectTypeFactory extends AbstractObjectFactory<MapCodec<? extends EnchantmentEntityEffect>> {
    public EnchantmentEntityEffectTypeFactory() {
        this(DefaultObjectRegistry.getFromInstance("$EnchantmentEntityEffectTypes"));
    }

    public EnchantmentEntityEffectTypeFactory(TemporalRegister<MapCodec<? extends EnchantmentEntityEffect>> register) {
        super(register);
    }
}
