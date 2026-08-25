package io.bloomish.api.engine.event.data.server.map;

import net.minecraft.core.Holder;
import net.minecraft.world.item.Item;

public record CompostableDto(Holder<? extends Item> item, float chance, boolean replace) {
}