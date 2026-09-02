package io.bloomish.api.util;

import io.bloomish.api.engine.context.ModContext;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;

import java.util.Set;
import java.util.stream.Collectors;

public final class ItemUtils {
    private ItemUtils() {
    }

    public static Item findMinecraftItem(String path) {
        return findItem(path, MinecraftConstants.MINECRAFT);
    }

    public static Item findModItem(String path) {
        return findItem(path, ModContext.getModId());
    }

    public static Item findItem(String fullPath) {
        return findItem(fullPath, ModContext.getModId());
    }

    public static Item findItem(String fullPath, String defaultNamespace) {
        return BuiltInRegistries.ITEM.get(ResourceLocationUtils.parseLocation(fullPath, defaultNamespace));
    }

    public static Set<Item> findItems(String path) {
        return BuiltInRegistries.ITEM.stream()
                .filter(item -> RegistryPathUtils.findItemPath(item).equals(path))
                .collect(Collectors.toSet());
    }
}
