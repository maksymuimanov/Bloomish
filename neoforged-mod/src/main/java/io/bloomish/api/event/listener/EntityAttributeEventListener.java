package io.bloomish.api.event.listener;

import io.bloomish.api.channel.ObserveObjectChannel;
import net.minecraft.core.Holder;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;

import java.util.stream.Stream;

@EventListener
public class EntityAttributeEventListener {
    private final Stream<EntityAttribute> entityAttributes;

    public EntityAttributeEventListener(
            @ObserveObjectChannel("EntityAttributeEventListener") Stream<EntityAttribute> entityAttributes
    ) {
        this.entityAttributes = entityAttributes;
    }

    @SuppressWarnings("unchecked")
    public void listen(EntityAttributeCreationEvent event) {
        this.entityAttributes.forEach(entityAttribute -> {
            EntityType<? extends LivingEntity> livingEntityType = (EntityType<? extends LivingEntity>) entityAttribute.entityType().value();
            event.put(livingEntityType, entityAttribute.attributes().build());
        });
    }

    public record EntityAttribute(
            Holder<? extends EntityType<?>> entityType,
            AttributeSupplier.Builder attributes
    ) {
    }
}
