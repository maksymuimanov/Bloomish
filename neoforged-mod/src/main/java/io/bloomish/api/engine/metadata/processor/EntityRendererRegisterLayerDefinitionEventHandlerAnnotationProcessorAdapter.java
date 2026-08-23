package io.bloomish.api.engine.metadata.processor;

import io.bloomish.api.engine.context.ModContext;
import io.bloomish.api.engine.metadata.MetadataLayer;
import io.bloomish.api.engine.metadata.annotation.injection.Processor;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

@Processor(EntityRendererRegisterLayerDefinitionEventHandlerAnnotationProcessorAdapter.NAME)
public class EntityRendererRegisterLayerDefinitionEventHandlerAnnotationProcessorAdapter extends AbstractEventHandlerAnnotationProcessorAdapter {
    public static final String NAME = "default_entity_renderer_register_layer_definition_event";

    @Override
    public void handle() {
        this.subscribeModEvent(EntityRenderersEvent.RegisterLayerDefinitions.class, event -> {
            this.processAll(MetadataLayer.ASYNC_STRATEGY_CONSUMER, ModContext.ALL_CLASSES);
        }, EventPriority.HIGHEST);
    }
}