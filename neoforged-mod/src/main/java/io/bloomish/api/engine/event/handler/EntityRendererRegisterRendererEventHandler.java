package io.bloomish.api.engine.event.handler;

import io.bloomish.api.channel.DataChannels;
import io.bloomish.api.channel.ValueChannelBus;
import io.bloomish.api.engine.event.subscriber.ModEventBusSubscriber;
import io.bloomish.api.engine.metadata.annotation.injection.Handler;
import io.bloomish.api.engine.metadata.annotation.injection.Injected;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

import java.util.function.Consumer;

@Injected
@Handler(EntityRenderersEvent.RegisterRenderers.class)
public class EntityRendererRegisterRendererEventHandler extends AbstractEventHandler<EntityRenderersEvent.RegisterRenderers> {
    private final ValueChannelBus channelBus;

    public EntityRendererRegisterRendererEventHandler(ModEventBusSubscriber eventBusSubscriber, ValueChannelBus channelBus) {
        super(eventBusSubscriber);
        this.channelBus = channelBus;
    }

    @Override
    protected void handle(EntityRenderersEvent.RegisterRenderers event) {
        this.channelBus.<Consumer<EntityRenderersEvent.RegisterRenderers>>forEachDrain(DataChannels.ENTITY_RENDERER_REGISTER_RENDERER_EVENT_HANDLER,
                consumer -> consumer.accept(event));
    }
}
