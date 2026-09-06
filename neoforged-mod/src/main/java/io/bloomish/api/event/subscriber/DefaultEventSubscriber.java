package io.bloomish.api.event.subscriber;

import io.bloomish.api.bean.Bean;
import net.neoforged.bus.api.Event;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.event.IModBusEvent;
import net.neoforged.neoforge.common.NeoForge;

import java.util.function.Consumer;

@Bean
public class DefaultEventSubscriber implements EventSubscriber {
    private final IEventBus modEventBus;

    public DefaultEventSubscriber(IEventBus modEventBus) {
        this.modEventBus = modEventBus;
    }

    @Override
    public <E extends Event> void subscribe(Class<E> eventClass, Consumer<E> eventConsumer, EventPriority priority) {
        boolean isModEvent = IModBusEvent.class.isAssignableFrom(eventClass);
        IEventBus eventBus = isModEvent ? this.modEventBus : NeoForge.EVENT_BUS;
        eventBus.addListener(priority, eventClass, eventConsumer);
    }
}
