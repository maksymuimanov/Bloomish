package io.bloomish.api.util;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;

import java.util.Objects;

public final class RegistryUtils {
    private RegistryUtils() {
    }

    public static <T> String findPath(Registry<T> registry, T value) {
        ResourceLocation location = Objects.requireNonNull(registry.getKey(value));
        return location.getPath();
    }

    public static <T> String findNamespacedPath(Registry<T> registry, T value) {
        ResourceLocation location = Objects.requireNonNull(registry.getKey(value));
        return location.toString();
    }

    public static <T> String findNamespacedPath(Registry<T> registry, T value, String prefix) {
        ResourceLocation location = Objects.requireNonNull(registry.getKey(value));
        return prefix.isBlank()
                ? location.toString()
                : ResourceLocationUtils.joinNamespacedPath(location, prefix, location.getPath());
    }
}
