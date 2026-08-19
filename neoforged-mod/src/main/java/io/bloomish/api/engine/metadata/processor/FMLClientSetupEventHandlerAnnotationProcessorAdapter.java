package io.bloomish.api.engine.metadata.processor;

import io.bloomish.api.engine.context.EngineContext;
import io.bloomish.api.engine.metadata.MetadataLayer;
import io.bloomish.api.engine.metadata.annotation.injection.Processor;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;

@Processor(FMLClientSetupEventHandlerAnnotationProcessorAdapter.NAME)
public class FMLClientSetupEventHandlerAnnotationProcessorAdapter extends AbstractEventHandlerAnnotationProcessorAdapter {
    public static final String NAME = "default_fml_client_setup_event";

    @Override
    public void handle() {
        this.subscribeModEvent(FMLClientSetupEvent.class, event -> {
            this.processAll(MetadataLayer.ASYNC_STRATEGY_CONSUMER, EngineContext.ALL_CLASSES);
        }, EventPriority.HIGHEST);
    }
}