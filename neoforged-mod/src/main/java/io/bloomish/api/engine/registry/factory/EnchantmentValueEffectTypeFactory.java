package io.bloomish.api.engine.registry.factory;

import com.mojang.serialization.MapCodec;
import io.bloomish.api.engine.context.DefaultObjectRegistry;
import io.bloomish.api.engine.registry.BloomishRegister;
import net.minecraft.world.item.enchantment.effects.EnchantmentValueEffect;

public class EnchantmentValueEffectTypeFactory extends AbstractObjectFactory<MapCodec<? extends EnchantmentValueEffect>> {
    public EnchantmentValueEffectTypeFactory() {
        this(DefaultObjectRegistry.getFromInstance("$EnchantmentValueEffectTypes"));
    }

    public EnchantmentValueEffectTypeFactory(BloomishRegister<MapCodec<? extends EnchantmentValueEffect>> register) {
        super(register);
    }
}
