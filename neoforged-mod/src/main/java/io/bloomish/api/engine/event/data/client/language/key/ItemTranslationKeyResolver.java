package io.bloomish.api.engine.event.data.client.language.key;

import io.bloomish.api.engine.metadata.annotation.injection.Injected;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;

@Injected
public class ItemTranslationKeyResolver extends AbstractResourceKeyResolver<Item> {
    private static final String PREFIX = "item";

    @Override
    protected ResourceKey<? extends Registry<Item>> getRegistryKey() {
        return Registries.ITEM;
    }

    @Override
    public String resolve(ResourceKey<Item> itemResourceKey) {
        return this.resolveTranslationKey(PREFIX, itemResourceKey);
    }
}
