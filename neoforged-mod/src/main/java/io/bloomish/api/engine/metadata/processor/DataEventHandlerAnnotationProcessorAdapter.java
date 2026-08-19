package io.bloomish.api.engine.metadata.processor;

import io.bloomish.api.engine.context.ModContext;
import io.bloomish.api.engine.metadata.MetadataLayer;
import io.bloomish.api.engine.metadata.annotation.injection.Processor;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.neoforge.data.event.GatherDataEvent;

@Processor(DataEventHandlerAnnotationProcessorAdapter.NAME)
public class DataEventHandlerAnnotationProcessorAdapter extends AbstractEventHandlerAnnotationProcessorAdapter {
    public static final String NAME = "default_data";

    @Override
    public void handle() {
        this.subscribeModEvent(GatherDataEvent.class, event -> {
            this.processAll(MetadataLayer.ASYNC_STRATEGY_CONSUMER, ModContext.NEO_MOD.getClasses());
        }, EventPriority.HIGHEST);
    }
}
