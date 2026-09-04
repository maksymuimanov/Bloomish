package io.bloomish.api.util;

import io.bloomish.api.engine.context.ModContext;
import net.minecraft.resources.ResourceLocation;

import java.util.stream.Collectors;

public final class ResourceLocationUtils {
    private static final String NAMESPACE_SEPARATOR = ":";

    private ResourceLocationUtils() {
    }

    public static ResourceLocation parseLocation(String fullPath) {
        return parseLocation(fullPath, ModContext.getModId());
    }

    public static ResourceLocation parseLocation(String fullPath, String defaultNamespace) {
        if (fullPath.contains(NAMESPACE_SEPARATOR)) {
            String[] pathParts = fullPath.split(NAMESPACE_SEPARATOR);
            return ResourceLocation.fromNamespaceAndPath(pathParts[0], pathParts[1]);
        } else {
            return ResourceLocation.fromNamespaceAndPath(defaultNamespace, fullPath);
        }
    }

    public static ResourceLocation createModLocation(String path) {
        return ResourceLocation.fromNamespaceAndPath(ModContext.getModId(), path);
    }

    public static ResourceLocation createMinecraftLocation(String path) {
        return ResourceLocation.fromNamespaceAndPath(MinecraftConstants.MINECRAFT, path);
    }

    public static String joinModPath(String pathPart, String... pathParts) {
        return joinNamespacedPath(ModContext.getModId(), pathPart, pathParts);
    }

    public static String joinMinecraftPath(String pathPart, String... pathParts) {
        return joinNamespacedPath(MinecraftConstants.MINECRAFT, pathPart, pathParts);
    }

    public static String joinNamespacedPath(ResourceLocation location, String prefix) {
        return joinNamespacedPath(location.getNamespace(), prefix, location.getPath());
    }

    public static String joinNamespacedPath(String namespace, String pathPart, String... pathParts) {
        return CollectionUtils.arrayListOf(pathPart, pathParts)
                .stream()
                .collect(Collectors.joining("/", namespace + ":", ""));
    }
}
