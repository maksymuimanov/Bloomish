package io.bloomish.api.trade;

import net.neoforged.bus.api.Event;

public interface TradeProvider<E extends Event, T extends Trade> {
    void provide(E event, T trade);
}