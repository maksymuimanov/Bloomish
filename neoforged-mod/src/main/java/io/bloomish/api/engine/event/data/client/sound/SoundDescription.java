package io.bloomish.api.engine.event.data.client.sound;

import net.neoforged.neoforge.common.data.SoundDefinition;

public record SoundDescription(String id, SoundDefinition.SoundType type, double volume, double pitch, int weight, int attenuationDistance, boolean stream, boolean preload) {
}
