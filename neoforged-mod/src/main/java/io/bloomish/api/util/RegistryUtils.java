package io.bloomish.api.util;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.Objects;

public final class RegistryUtils {
    private RegistryUtils() {
    }

    public static String findBlockPath(Block block) {
        return findPath(BuiltInRegistries.BLOCK, block);
    }

    public static String findItemPath(Item item) {
        return findPath(BuiltInRegistries.ITEM, item);
    }

    public static <T> String findPath(Registry<T> registry, T value) {
        ResourceLocation location = Objects.requireNonNull(registry.getKey(value));
        return location.getPath();
    }

    public static String findBlockNamespacedPath(Block block, String prefix) {
        return findNamespacedPath(BuiltInRegistries.BLOCK, block, prefix);
    }

    public static String findItemNamespacedPath(Item item, String prefix) {
        return findNamespacedPath(BuiltInRegistries.ITEM, item, prefix);
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
