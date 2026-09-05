package io.bloomish.api.event.listener;

import io.bloomish.api.channel.deprecated.DataChannels;
import io.bloomish.api.channel.deprecated.KeyedChannelBus;
import net.minecraft.core.Holder;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;

@EventListener
public class EntityAttributeEventListener {
    private final KeyedChannelBus channelBus;

    public EntityAttributeEventListener(KeyedChannelBus channelBus) {
        this.channelBus = channelBus;
    }

    public void listen(EntityAttributeCreationEvent event) {
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
