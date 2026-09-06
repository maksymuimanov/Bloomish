package io.bloomish.api.event.subscriber;

import net.neoforged.bus.api.Event;
import net.neoforged.bus.api.EventPriority;

import java.util.function.Consumer;

public interface EventSubscriber {
    default <E extends Event> void subscribe(Class<E> eventClass, Consumer<E> eventConsumer) {
        this.subscribe(eventClass, eventConsumer, EventPriority.NORMAL);
    }

    <E extends Event> void subscribe(Class<E> eventClass, Consumer<E> eventConsumer, EventPriority priority);
}

