package io.bloomish.api.engine.event.handler;

import io.bloomish.api.channel.BiChannelBus;
import io.bloomish.api.channel.Channels;
import io.bloomish.api.engine.metadata.annotation.injection.Handler;
import io.bloomish.api.engine.metadata.annotation.injection.Injected;
import net.minecraft.core.Holder;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;

@Injected
@Handler(EntityAttributeCreationEvent.class)
public class EntityAttributeEventHandler implements EventHandler {
    private final BiChannelBus biChannelBus;

    public EntityAttributeEventHandler(BiChannelBus biChannelBus) {
        this.biChannelBus = biChannelBus;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void handle() {
        this.subscribeModEvent(EntityAttributeCreationEvent.class, event -> {
            this.biChannelBus.<Holder<? extends EntityType<?>>, AttributeSupplier.Builder>drain(Channels.ENTITY_ATTRIBUTE_EVENT_HANDLER_BI_CHANNEL)
                    .forEach(entry -> {
                        Holder<? extends EntityType<?>> holder = entry.key();
                        AttributeSupplier.Builder attributes = entry.value();
                        event.put((EntityType<? extends LivingEntity>) holder.value(), attributes.build());
                    });
        });
    }
}
