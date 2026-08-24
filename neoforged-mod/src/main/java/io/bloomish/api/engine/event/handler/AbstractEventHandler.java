package io.bloomish.api.engine.event.handler;

import io.bloomish.api.engine.event.subscriber.EventBusSubscriber;
import net.neoforged.bus.api.Event;

public abstract class AbstractEventHandler<E extends Event> implements EventHandler {
    private final EventBusSubscriber eventBusSubscriber;

    protected AbstractEventHandler(EventBusSubscriber eventBusSubscriber) {
        this.eventBusSubscriber = eventBusSubscriber;
    }

    @Override
    public void handle() {
        this.eventBusSubscriber.subscribe((E event) -> handle(event));
    }

    protected abstract void handle(E event);

    protected EventBusSubscriber getEventSubscriber() {
        return eventBusSubscriber;
    }
}
