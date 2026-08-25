package io.bloomish.api.util;

import io.bloomish.api.engine.context.ModContext;
import net.minecraft.resources.ResourceLocation;

import java.util.stream.Collectors;

public final class ResourceLocationUtils {
    private static final String NAMESPACE_SEPARATOR = ":";

    private ResourceLocationUtils() {
    }

    public static ResourceLocation parseModLocation(String fullPath) {
        return parseLocation(fullPath, ModContext.getModId());
    }

    public static ResourceLocation parseMinecraftLocation(String fullPath) {
        return parseLocation(fullPath, MinecraftConstants.MINECRAFT);
    }

    public static ResourceLocation parseLocation(String fullPath, String defaultNamespace) {
        if (fullPath.contains(NAMESPACE_SEPARATOR)) {
            String[] split = fullPath.split(NAMESPACE_SEPARATOR);
            return ResourceLocation.fromNamespaceAndPath(split[0], split[1]);
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

    public static String joinPath(ResourceLocation location, String pathPart, String... pathParts) {
        return joinPath(location.getNamespace(), pathPart, pathParts);
    }

    public static String joinPath(String namespace, String pathPart, String... pathParts) {
        return CollectionUtils.listOf(pathPart, pathParts)
                .stream()
                .collect(Collectors.joining("/", namespace + ":", ""));
    }
}
