package io.bloomish.api.data.client.language.key;

import io.bloomish.api.engine.metadata.annotation.injection.Injected;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.enchantment.Enchantment;

@Injected
public class EnchantmentTranslationKeyResolver extends AbstractResourceKeyResolver<Enchantment> {
    public static final String PREFIX = "enchantment";

    @Override
    protected ResourceKey<? extends Registry<Enchantment>> getRegistryKey() {
        return Registries.ENCHANTMENT;
    }

    @Override
    public String resolve(ResourceKey<Enchantment> enchantmentResourceKey) {
        return this.resolveTranslationKey(PREFIX, enchantmentResourceKey);
    }
}
