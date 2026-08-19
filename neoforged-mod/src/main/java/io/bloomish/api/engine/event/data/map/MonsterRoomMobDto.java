package io.bloomish.api.engine.event.data.map;

import net.minecraft.core.Holder;
import net.minecraft.world.entity.EntityType;

public record MonsterRoomMobDto(Holder<EntityType<?>> entity, int weight, boolean replace) {
}