package io.bloomish.api.engine.event.data.client.language.transformer;

import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvent;

public class SoundEventTransformer implements KeyTransformer<ResourceKey<SoundEvent>> {
    public static final String PREFIX = "sound";

    @Override
    public String transform(ResourceKey<SoundEvent> soundEvent) {
        return this.transformResourceKey(PREFIX, soundEvent);
    }
}
