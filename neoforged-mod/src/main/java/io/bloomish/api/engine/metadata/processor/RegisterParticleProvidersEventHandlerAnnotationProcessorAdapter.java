package io.bloomish.api.engine.metadata.processor;

import io.bloomish.api.engine.context.ModContext;
import io.bloomish.api.engine.metadata.MetadataLayer;
import io.bloomish.api.engine.metadata.annotation.injection.Processor;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;

@Processor(RegisterParticleProvidersEventHandlerAnnotationProcessorAdapter.NAME)
public class RegisterParticleProvidersEventHandlerAnnotationProcessorAdapter extends AbstractEventHandlerAnnotationProcessorAdapter {
    public static final String NAME = "default_register_particle_provider_event";

    @Override
    public void handle() {
        this.subscribeModEvent(RegisterParticleProvidersEvent.class, event -> {
            this.processAll(MetadataLayer.ASYNC_STRATEGY_CONSUMER, ModContext.ALL_CLASSES);
        }, EventPriority.HIGHEST);
    }
}