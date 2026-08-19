package io.bloomish.example.entity;

import io.bloomish.api.engine.context.DefaultObjectRegistry;
import io.bloomish.api.engine.metadata.annotation.event.renderer.RegisterEntityRenderer;
import io.bloomish.api.engine.registry.factory.EntityTypeFactory;
import io.bloomish.example.entity.renderer.ExampleRenderer;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.neoforge.registries.DeferredHolder;

public final class ExampleEntityTypes {
    private static final EntityTypeFactory ENTITY_TYPE_FACTORY = DefaultObjectRegistry.getFromInstance(EntityTypeFactory.class);

    @RegisterEntityRenderer(ExampleRenderer.class)
    public static final DeferredHolder<EntityType<?>, EntityType<ExampleEntity>> EXAMPLE_ENTITY = ENTITY_TYPE_FACTORY.create("example_entity", ExampleEntity::new, MobCategory.MISC, 1f, 1f);
}
