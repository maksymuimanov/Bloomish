package io.bloomish.api.engine.registry.factory;

import com.mojang.serialization.MapCodec;
import io.bloomish.api.engine.context.DefaultObjectRegistry;
import io.bloomish.api.engine.registry.BloomishRegister;
import net.minecraft.world.item.enchantment.effects.EnchantmentLocationBasedEffect;

public class EnchantmentLocationBasedEffectTypeFactory extends AbstractObjectFactory<MapCodec<? extends EnchantmentLocationBasedEffect>> {
    public EnchantmentLocationBasedEffectTypeFactory() {
        this(DefaultObjectRegistry.getFromInstance("$EnchantmentLocationBasedEffectTypes"));
    }

    public EnchantmentLocationBasedEffectTypeFactory(BloomishRegister<MapCodec<? extends EnchantmentLocationBasedEffect>> register) {
        super(register);
    }
}
