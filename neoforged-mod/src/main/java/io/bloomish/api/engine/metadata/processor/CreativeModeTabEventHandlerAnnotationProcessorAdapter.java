package io.bloomish.api.engine.metadata.processor;

import io.bloomish.api.engine.context.EngineContext;
import io.bloomish.api.engine.event.handler.CreativeModeTabEventHandler;
import io.bloomish.api.engine.metadata.MetadataLayer;
import io.bloomish.api.engine.metadata.annotation.injection.Processor;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;

@Processor(CreativeModeTabEventHandlerAnnotationProcessorAdapter.NAME)
public class CreativeModeTabEventHandlerAnnotationProcessorAdapter extends AbstractEventHandlerAnnotationProcessorAdapter {
    public static final String NAME = "default_creative_mode_tab_event";

    @Override
    public void handle() {
        this.subscribeModEvent(BuildCreativeModeTabContentsEvent.class, event -> {
            if (!CreativeModeTabEventHandler.CREATIVE_MODE_TABS_CONTENT.isEmpty()) return;
            this.processAll(MetadataLayer.ASYNC_STRATEGY_CONSUMER, EngineContext.ALL_CLASSES);
        }, EventPriority.HIGHEST);
    }
}