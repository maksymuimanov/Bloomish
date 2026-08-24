package io.bloomish.api.engine.event.handler;

import io.bloomish.api.channel.DataChannels;
import io.bloomish.api.channel.KeyedChannelBus;
import io.bloomish.api.engine.event.subscriber.ModEventBusSubscriber;
import io.bloomish.api.engine.metadata.annotation.injection.Injected;
import net.minecraft.core.Holder;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;

@Injected
public class EntityAttributeEventHandler extends AbstractEventHandler<EntityAttributeCreationEvent> {
    private final KeyedChannelBus channelBus;

    public EntityAttributeEventHandler(ModEventBusSubscriber eventBusSubscriber, KeyedChannelBus channelBus) {
        super(eventBusSubscriber);
        this.channelBus = channelBus;
    }

    @Override
    protected void handle(EntityAttributeCreationEvent event) {
        this.channelBus.<Holder<? extends EntityType<?>>, AttributeSupplier.Builder>forEachDrain(DataChannels.ENTITY_ATTRIBUTE_EVENT_HANDLER,
                (entityType, attributes) ->
                        this.addAttributesToEntity(event, entityType, attributes));
    }

    @SuppressWarnings("unchecked")
    private void addAttributesToEntity(EntityAttributeCreationEvent event, Holder<? extends EntityType<?>> entityType, AttributeSupplier.Builder attributes) {
        EntityType<? extends LivingEntity> livingEntityType = (EntityType<? extends LivingEntity>) entityType.value();
        event.put(livingEntityType, attributes.build());
    }
}
