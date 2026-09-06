package io.bloomish.api.event.listener;

import io.bloomish.api.bean.Bean;
import io.bloomish.api.channel.ObserveObjectChannel;
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;

import java.util.function.Consumer;
import java.util.stream.Stream;

@Bean
public class RegisterParticleProvidersEventListener {
    private final Stream<Consumer<RegisterParticleProvidersEvent>> registerParticleProvidersEventConsumers;

    public RegisterParticleProvidersEventListener(
            @ObserveObjectChannel("RegisterParticleProvidersEventListener") Stream<Consumer<RegisterParticleProvidersEvent>> registerParticleProvidersEventConsumers
    ) {
        this.registerParticleProvidersEventConsumers = registerParticleProvidersEventConsumers;
    }

    @ListenEvent
    public void listen(RegisterParticleProvidersEvent event) {
        this.registerParticleProvidersEventConsumers.forEach(consumer -> consumer.accept(event));
    }
}
