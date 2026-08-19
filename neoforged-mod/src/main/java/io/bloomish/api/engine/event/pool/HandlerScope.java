package io.bloomish.api.engine.event.pool;

import net.neoforged.bus.api.Event;

public record HandlerScope(Class<? extends Event> eventClass) {
}