package io.bloomish.api.data.client.language.key;

import io.bloomish.api.engine.metadata.annotation.injection.Injected;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.effect.MobEffect;

@Injected
public class MobEffectTranslationKeyResolver extends AbstractResourceKeyResolver<MobEffect> {
    public static final String PREFIX = "effect";

    @Override
    protected ResourceKey<? extends Registry<MobEffect>> getRegistryKey() {
        return Registries.MOB_EFFECT;
    }

    @Override
    public String resolve(ResourceKey<MobEffect> mobEffectResourceKey) {
        return this.resolveTranslationKey(PREFIX, mobEffectResourceKey);
    }
}
