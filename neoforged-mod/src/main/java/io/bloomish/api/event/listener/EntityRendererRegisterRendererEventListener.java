package io.bloomish.api.event.listener;

import io.bloomish.api.bean.Bean;
import io.bloomish.api.channel.ObserveObjectChannel;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

import java.util.function.Consumer;
import java.util.stream.Stream;

@Bean
public class EntityRendererRegisterRendererEventListener {
    private final Stream<Consumer<EntityRenderersEvent.RegisterRenderers>> registerRenderersConsumers;

    public EntityRendererRegisterRendererEventListener(
            @ObserveObjectChannel("EntityRendererRegisterRendererEventListener") Stream<Consumer<EntityRenderersEvent.RegisterRenderers>> registerRenderersConsumers
    ) {
        this.registerRenderersConsumers = registerRenderersConsumers;
    }

    @ListenEvent
    public void listen(EntityRenderersEvent.RegisterRenderers event) {
        this.registerRenderersConsumers.forEach(consumer -> consumer.accept(event));
    }
}
