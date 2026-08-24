package io.bloomish.api.engine.event.handler;

import io.bloomish.api.channel.DataChannels;
import io.bloomish.api.channel.KeyedChannelBus;
import io.bloomish.api.engine.event.subscriber.ModEventBusSubscriber;
import io.bloomish.api.engine.metadata.annotation.injection.Handler;
import io.bloomish.api.engine.metadata.annotation.injection.Injected;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

@Injected
@Handler(EntityRenderersEvent.RegisterLayerDefinitions.class)
public class EntityRendererRegisterLayerDefinitionEventHandler extends AbstractEventHandler<EntityRenderersEvent.RegisterLayerDefinitions> {
    private final KeyedChannelBus channelBus;

    public EntityRendererRegisterLayerDefinitionEventHandler(ModEventBusSubscriber eventBusSubscriber, KeyedChannelBus channelBus) {
        super(eventBusSubscriber);
        this.channelBus = channelBus;
    }

    @Override
    protected void handle(EntityRenderersEvent.RegisterLayerDefinitions event) {
        this.channelBus.<ModelLayerLocation, LayerDefinition>forEachDrain(DataChannels.ENTITY_RENDERER_REGISTER_LAYER_DEFINITION_EVENT_HANDLER,
                (location, definition) ->
                        this.addLayerDefinition(event, location, definition));

    }

    private void addLayerDefinition(EntityRenderersEvent.RegisterLayerDefinitions event, ModelLayerLocation location, LayerDefinition definition) {
        event.registerLayerDefinition(location, () -> definition);
    }
}
