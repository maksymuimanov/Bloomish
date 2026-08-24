package io.bloomish.api.engine.event.subscriber;

import io.bloomish.api.engine.context.ModContext;
import io.bloomish.api.engine.event.EventBusSubscriber;
import io.bloomish.api.engine.metadata.annotation.injection.Injected;
import net.neoforged.bus.api.IEventBus;

@Injected
public class ModEventBusSubscriber implements EventBusSubscriber {
    @Override
    public IEventBus getEventBus() {
        return ModContext.getObject(IEventBus.class);
    }
}
