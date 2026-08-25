package io.bloomish.example.enchantment;

import io.bloomish.api.engine.metadata.annotation.data.GenerateEnchantment;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateAmericanEnglish;
import io.bloomish.api.util.DeprecatedResourceUtils;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.enchantment.Enchantment;

public final class ExampleEnchantments {
    @TranslateAmericanEnglish("Example Enchantment")
    @GenerateEnchantment(ExampleEnchantmentEntityEffectDescription.class)
    public static final ResourceKey<Enchantment> EXAMPLE_ENCHANTMENT = DeprecatedResourceUtils.createKey(Registries.ENCHANTMENT, "example_enchantment_entity_effect");
}
