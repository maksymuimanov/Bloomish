package io.bloomish.api.engine.event.data.server.enchantment;

import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.world.item.enchantment.Enchantment;

public interface EnchantmentProvider {
    void registerEnchantments(BootstrapContext<Enchantment> context);
}
