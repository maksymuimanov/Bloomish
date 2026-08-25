package io.bloomish.api.engine.registry.factory;

import com.mojang.serialization.MapCodec;
import io.bloomish.api.engine.context.DefaultObjectRegistry;
import io.bloomish.api.engine.registry.BloomishRegister;
import net.minecraft.world.item.enchantment.providers.EnchantmentProvider;

public class EnchantmentProviderTypeFactory extends AbstractObjectFactory<MapCodec<? extends EnchantmentProvider>> {
    public EnchantmentProviderTypeFactory() {
        this(DefaultObjectRegistry.getFromInstance("$EnchantmentProviderTypes"));
    }

    public EnchantmentProviderTypeFactory(BloomishRegister<MapCodec<? extends EnchantmentProvider>> register) {
        super(register);
    }
}
