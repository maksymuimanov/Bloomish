package io.bloomish.api.util;

import net.minecraft.resources.ResourceKey;

import java.util.stream.Stream;

public final class ResourceKeyUtils {
    private static final String NAMESPACE_SEPARATOR = ":";

    private ResourceKeyUtils() {
    }

    @SuppressWarnings("unchecked")
    public static <T> Stream<ResourceKey<T>> extractResourceKeys(Class<?> resourceClassHolder) {
        return ReflectionUtils.getStaticFieldStream(
                resourceClassHolder,
                field -> ResourceKey.class.isAssignableFrom(field.getType()),
                resourceKey -> (ResourceKey<T>) resourceKey
        );
    }
}
