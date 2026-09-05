package io.bloomish.api.event.listener;

import io.bloomish.api.channel.deprecated.DataChannels;
import io.bloomish.api.channel.deprecated.KeyedChannelBus;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

@EventListener
public class EntityRendererRegisterLayerDefinitionEventListener {
    private final KeyedChannelBus channelBus;

    public EntityRendererRegisterLayerDefinitionEventListener(KeyedChannelBus channelBus) {
        this.channelBus = channelBus;
    }

    public void listen(EntityRenderersEvent.RegisterLayerDefinitions event) {
        this.channelBus.<ModelLayerLocation, LayerDefinition>forEachDrain(DataChannels.ENTITY_RENDERER_REGISTER_LAYER_DEFINITION_EVENT_HANDLER,
                (location, definition) ->
                        this.addLayerDefinition(event, location, definition));

    }

    private void addLayerDefinition(EntityRenderersEvent.RegisterLayerDefinitions event, ModelLayerLocation location, LayerDefinition definition) {
        event.registerLayerDefinition(location, () -> definition);
    }
}
