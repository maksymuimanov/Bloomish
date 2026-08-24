package io.bloomish.api.engine.event.subscriber;

import net.neoforged.bus.api.Event;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.bus.api.IEventBus;

import java.util.function.Consumer;

public interface EventBusSubscriber {
    default void subscribe(Consumer<? extends Event> eventConsumer) {
        this.subscribe(eventConsumer, EventPriority.NORMAL);
    }

    default void subscribe(Consumer<? extends Event> eventConsumer, EventPriority priority) {
        this.getEventBus().addListener(priority, eventConsumer);
    }

    IEventBus getEventBus();
}

