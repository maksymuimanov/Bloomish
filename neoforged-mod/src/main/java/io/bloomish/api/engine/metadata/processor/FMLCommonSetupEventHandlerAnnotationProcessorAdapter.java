package io.bloomish.api.engine.metadata.processor;

import io.bloomish.api.ApiMod;
import io.bloomish.api.engine.context.EngineContext;
import io.bloomish.api.engine.metadata.MetadataLayer;
import io.bloomish.api.engine.metadata.annotation.injection.Processor;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;

@Processor(FMLCommonSetupEventHandlerAnnotationProcessorAdapter.NAME)
public class FMLCommonSetupEventHandlerAnnotationProcessorAdapter extends AbstractEventHandlerAnnotationProcessorAdapter {
    public static final String NAME = "default_fml_common_setup_event";

    @Override
    public void handle() {
        this.subscribeModEvent(FMLCommonSetupEvent.class, event -> {
            ApiMod.LOGGER.info("FMLCommonSetupEvent received for modId: {}", EngineContext.currentMod.getModId());
            event.enqueueWork(() -> this.processAll(MetadataLayer.ASYNC_STRATEGY_CONSUMER, EngineContext.ALL_CLASSES));
        }, EventPriority.HIGHEST);
    }
}