package io.bloomish.api.data.client.sound;

import net.minecraft.core.Holder;
import net.minecraft.sounds.SoundEvent;

public record SoundHolder(Holder<SoundEvent> sound, boolean replace) {
}
