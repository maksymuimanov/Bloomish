package io.bloomish.api.engine.metadata.processor;

import io.bloomish.api.engine.context.EngineContext;
import io.bloomish.api.engine.metadata.MetadataLayer;
import io.bloomish.api.engine.metadata.annotation.injection.Processor;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

@Processor(EntityRendererRegisterRendererEventHandlerAnnotationProcessorAdapter.NAME)
public class EntityRendererRegisterRendererEventHandlerAnnotationProcessorAdapter extends AbstractEventHandlerAnnotationProcessorAdapter {
    public static final String NAME = "default_entity_renderer_register_renderer_event";

    @Override
    public void handle() {
        this.subscribeModEvent(EntityRenderersEvent.RegisterRenderers.class, event -> {
            this.processAll(MetadataLayer.ASYNC_STRATEGY_CONSUMER, EngineContext.ALL_CLASSES);
        }, EventPriority.HIGHEST);
    }
}