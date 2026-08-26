package io.bloomish.api.engine.event.data.client.language.key;

import net.minecraft.Util;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;

public interface TranslationKeyResolver<T> {
    @SuppressWarnings("unchecked")
    default String tryResolve(Object object) {
        return this.supports(object)
                ? this.resolve((T) object)
                : null;
    }

    boolean supports(Object object);

    String resolve(T t);

    default String resolveTranslationKey(String prefix, ResourceKey<?> key) {
        ResourceLocation location = key.location();
        return Util.makeDescriptionId(prefix, location);
    }
}
