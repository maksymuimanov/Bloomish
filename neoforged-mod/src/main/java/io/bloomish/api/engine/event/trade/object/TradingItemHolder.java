package io.bloomish.api.engine.event.trade.object;

import net.minecraft.world.item.Item;

public record TradingItemHolder(Item item, int itemCount) {
}
