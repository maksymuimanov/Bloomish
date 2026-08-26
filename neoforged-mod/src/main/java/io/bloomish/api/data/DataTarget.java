package io.bloomish.api.data;

import io.bloomish.api.engine.context.ModContext;
import io.bloomish.api.util.MinecraftConstants;
import net.minecraft.data.PackOutput;

import java.nio.file.Path;

public record DataTarget(
        PackOutput.Target target,
        String namespace,
        Path path
) {
    public static DataTarget createModData(String pathPart, String... pathParts) {
        return createData(ModContext.getModId(), pathPart, pathParts);
    }

    public static DataTarget createMinecraftData(String pathPart, String... pathParts) {
        return createData(MinecraftConstants.MINECRAFT, pathPart, pathParts);
    }

    public static DataTarget createData(String namespace, String pathPart, String... pathParts) {
        return createData(namespace, Path.of(pathPart, pathParts));
    }

    public static DataTarget createData(String namespace, Path path) {
        return new DataTarget(PackOutput.Target.DATA_PACK, namespace, path);
    }

    public static DataTarget createModAsset(String pathPart, String... pathParts) {
        return createAsset(ModContext.getModId(), pathPart, pathParts);
    }

    public static DataTarget createMinecraftAsset(String pathPart, String... pathParts) {
        return createAsset(MinecraftConstants.MINECRAFT, pathPart, pathParts);
    }

    public static DataTarget createAsset(String namespace, String pathPart, String... pathParts) {
        return createAsset(namespace, Path.of(pathPart, pathParts));
    }

    public static DataTarget createAsset(String namespace, Path path) {
        return new DataTarget(PackOutput.Target.RESOURCE_PACK, namespace, path);
    }
}
