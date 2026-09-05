package io.bloomish.api.event.listener;

import io.bloomish.api.channel.deprecated.DataChannels;
import io.bloomish.api.channel.deprecated.ValueChannelBus;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

import java.util.function.Consumer;

@EventListener
public class EntityRendererRegisterRendererEventListener {
    private final ValueChannelBus channelBus;

    public EntityRendererRegisterRendererEventListener(ValueChannelBus channelBus) {
        this.channelBus = channelBus;
    }

    public void listen(EntityRenderersEvent.RegisterRenderers event) {
        this.channelBus.<Consumer<EntityRenderersEvent.RegisterRenderers>>forEachDrain(DataChannels.ENTITY_RENDERER_REGISTER_RENDERER_EVENT_HANDLER,
                consumer -> consumer.accept(event));
    }
}
