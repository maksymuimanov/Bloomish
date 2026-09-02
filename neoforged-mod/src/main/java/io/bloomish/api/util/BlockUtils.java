package io.bloomish.api.util;

import io.bloomish.api.engine.context.ModContext;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Block;

import java.util.Set;
import java.util.stream.Collectors;

public final class BlockUtils {
    private BlockUtils() {
    }

    public static Block findMinecraftBlock(String path) {
        return findBlock(path, MinecraftConstants.MINECRAFT);
    }

    public static Block findModBlock(String path) {
        return findBlock(path, ModContext.getModId());
    }

    public static Block findBlock(String fullPath) {
        return findBlock(fullPath, ModContext.getModId());
    }
    
    public static Block findBlock(String fullPath, String defaultNamespace) {
        return BuiltInRegistries.BLOCK.get(ResourceLocationUtils.parseLocation(fullPath, defaultNamespace));
    }

    public static Set<Block> findBlocks(String path) {
        return BuiltInRegistries.BLOCK.stream()
                .filter(block -> RegistryPathUtils.findBlockPath(block).equals(path))
                .collect(Collectors.toSet());
    }
}
