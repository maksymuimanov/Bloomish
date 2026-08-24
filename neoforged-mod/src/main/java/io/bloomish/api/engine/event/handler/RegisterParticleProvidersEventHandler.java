package io.bloomish.api.engine.event.handler;

import io.bloomish.api.channel.DataChannels;
import io.bloomish.api.channel.ValueChannelBus;
import io.bloomish.api.engine.event.subscriber.ModEventBusSubscriber;
import io.bloomish.api.engine.metadata.annotation.injection.Handler;
import io.bloomish.api.engine.metadata.annotation.injection.Injected;
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;

import java.util.function.Consumer;

@Injected
@Handler(RegisterParticleProvidersEvent.class)
public class RegisterParticleProvidersEventHandler extends AbstractEventHandler<RegisterParticleProvidersEvent> {
    private final ValueChannelBus channelBus;

    public RegisterParticleProvidersEventHandler(ModEventBusSubscriber eventBusSubscriber, ValueChannelBus channelBus) {
        super(eventBusSubscriber);
        this.channelBus = channelBus;
    }
    @Override
    protected void handle(RegisterParticleProvidersEvent event) {
        this.channelBus.<Consumer<RegisterParticleProvidersEvent>>forEachDrain(DataChannels.REGISTER_PARTICLE_PROVIDERS_EVENT_HANDLER,
                consumer -> consumer.accept(event));
    }
}
