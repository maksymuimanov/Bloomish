package io.bloomish.api.data.client.language.key;

import io.bloomish.api.engine.metadata.annotation.injection.Injected;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;

@Injected
public class EntityTypeTranslationKeyResolver extends AbstractResourceKeyResolver<EntityType<?>> {
    public static final String PREFIX = "entity";

    @Override
    protected ResourceKey<? extends Registry<EntityType<?>>> getRegistryKey() {
        return Registries.ENTITY_TYPE;
    }

    @Override
    public String resolve(ResourceKey<EntityType<?>> entityTypeResourceKey) {
        return this.resolveTranslationKey(PREFIX, entityTypeResourceKey);
    }
}
