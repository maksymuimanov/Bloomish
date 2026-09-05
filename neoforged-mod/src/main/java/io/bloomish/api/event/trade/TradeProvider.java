package io.bloomish.api.event.trade;

import net.neoforged.bus.api.Event;

public interface TradeProvider<E extends Event, T extends Trade> {
    void provide(E event, T trade);
}