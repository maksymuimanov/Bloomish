package io.bloomish.api.data.client.language.key;

import io.bloomish.api.bean.Bean;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvent;

@Bean
public class SoundEventTranslationKeyResolver extends AbstractResourceKeyResolver<SoundEvent> {
    public static final String PREFIX = "sound";

    @Override
    protected ResourceKey<? extends Registry<SoundEvent>> getRegistryKey() {
        return Registries.SOUND_EVENT;
    }

    @Override
    public String resolve(ResourceKey<SoundEvent> soundEventResourceKey) {
        return this.resolveTranslationKey(PREFIX, soundEventResourceKey);
    }
}
