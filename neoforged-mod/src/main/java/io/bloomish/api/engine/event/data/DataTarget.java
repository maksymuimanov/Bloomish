package io.bloomish.api.engine.event.data;

import io.bloomish.api.engine.context.ModContext;
import io.bloomish.api.util.MinecraftConstants;
import net.minecraft.data.PackOutput;

import java.nio.file.Path;

public record DataTarget(
        PackOutput.Target target,
        String namespace,
        String path
) {
    public static DataTarget createModDataPack(String path) {
        return createDataPack(ModContext.getModId(), path);
    }

    public static DataTarget createMinecraftDataPack(String path) {
        return createDataPack(MinecraftConstants.MINECRAFT, path);
    }

    public static DataTarget createDataPack(String namespace, String path) {
        return new DataTarget(PackOutput.Target.DATA_PACK, namespace, path);
    }

    public static DataTarget createModResourcePack(String path) {
        return createResourcePack(ModContext.getModId(), path);
    }

    public static DataTarget createMinecraftResourcePack(String path) {
        return createResourcePack(MinecraftConstants.MINECRAFT, path);
    }

    // TODO
    public static DataTarget createResourcePack(String namespace, Path path) {
        return createResourcePack(namespace, path.toString());
    }

    public static DataTarget createResourcePack(String namespace, String path) {
        return new DataTarget(PackOutput.Target.RESOURCE_PACK, namespace, path);
    }
}
