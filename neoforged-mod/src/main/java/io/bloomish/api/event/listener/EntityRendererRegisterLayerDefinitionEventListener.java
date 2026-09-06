package io.bloomish.api.event.listener;

import io.bloomish.api.channel.ObserveObjectChannel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

import java.util.stream.Stream;

@EventListener
public class EntityRendererRegisterLayerDefinitionEventListener {
    private final Stream<ModelLocationLayerDefinition> modelLocationLayerDefinitions;

    public EntityRendererRegisterLayerDefinitionEventListener(
            @ObserveObjectChannel("EntityRendererRegisterLayerDefinitionEventListener") Stream<ModelLocationLayerDefinition> modelLocationLayerDefinitions
    ) {
        this.modelLocationLayerDefinitions = modelLocationLayerDefinitions;
    }

    public void listen(EntityRenderersEvent.RegisterLayerDefinitions event) {
        this.modelLocationLayerDefinitions.forEach(modelLocationLayerDefinition ->
                event.registerLayerDefinition(modelLocationLayerDefinition.location(), modelLocationLayerDefinition::definition));
    }

    public record ModelLocationLayerDefinition(
            ModelLayerLocation location,
            LayerDefinition definition
    ) {
    }
}
