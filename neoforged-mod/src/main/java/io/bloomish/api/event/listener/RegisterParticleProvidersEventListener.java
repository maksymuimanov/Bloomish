package io.bloomish.api.event.listener;

import io.bloomish.api.channel.deprecated.DataChannels;
import io.bloomish.api.channel.deprecated.ValueChannelBus;
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;

import java.util.function.Consumer;

@EventListener
public class RegisterParticleProvidersEventListener {
    private final ValueChannelBus channelBus;

    public RegisterParticleProvidersEventListener(ValueChannelBus channelBus) {
        this.channelBus = channelBus;
    }

    public void listen(RegisterParticleProvidersEvent event) {
        this.channelBus.<Consumer<RegisterParticleProvidersEvent>>forEachDrain(DataChannels.REGISTER_PARTICLE_PROVIDERS_EVENT_HANDLER,
                consumer -> consumer.accept(event));
    }
}
