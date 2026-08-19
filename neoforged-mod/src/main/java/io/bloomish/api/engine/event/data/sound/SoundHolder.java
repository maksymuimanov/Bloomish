package io.bloomish.api.engine.event.data.sound;

import net.minecraft.core.Holder;
import net.minecraft.sounds.SoundEvent;

public record SoundHolder(Holder<SoundEvent> sound, boolean replace) {
}
