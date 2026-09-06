package io.bloomish.api.data.client.language.key;

import io.bloomish.api.bean.Bean;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.damagesource.DamageType;

@Bean
public class DamageTypeTranslationKeyResolver extends AbstractResourceKeyResolver<DamageType> {
    public static final String PREFIX = "damage";

    @Override
    protected ResourceKey<? extends Registry<DamageType>> getRegistryKey() {
        return Registries.DAMAGE_TYPE;
    }

    @Override
    public String resolve(ResourceKey<DamageType> damageTypeResourceKey) {
        return this.resolveTranslationKey(PREFIX, damageTypeResourceKey);
    }
}
