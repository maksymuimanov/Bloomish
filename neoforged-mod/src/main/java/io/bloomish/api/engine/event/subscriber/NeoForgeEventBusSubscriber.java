package io.bloomish.api.engine.event.subscriber;

import io.bloomish.api.engine.event.EventBusSubscriber;
import io.bloomish.api.engine.metadata.annotation.injection.Injected;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.NeoForge;

@Injected
public class NeoForgeEventBusSubscriber implements EventBusSubscriber {
    @Override
    public IEventBus getEventBus() {
        return NeoForge.EVENT_BUS;
    }
}
