package io.bloomish.api.data.client.language.key;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;

public abstract class AbstractResourceKeyResolver<T> implements TranslationKeyResolver<ResourceKey<T>> {
    public boolean supports(Object object) {
        return object instanceof ResourceKey<?> key && key.isFor(this.getRegistryKey());
    }

    protected abstract ResourceKey<? extends Registry<T>> getRegistryKey();
}
