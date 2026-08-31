package io.bloomish.api.data;

import io.bloomish.api.util.ResourceLocationUtils;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.PackOutput;

import java.io.Serializable;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public abstract class AbstractMultiDataProvider implements BloomishDataProvider {
    private static final String JSON_FILE_EXTENSION = ".json";
    private final Map<DataTarget, Object> data;
    private final PackOutput packOutput;

    protected AbstractMultiDataProvider(PackOutput packOutput) {
        this(Map.of(), packOutput);
    }

    protected AbstractMultiDataProvider(Map<DataTarget, Serializable> data, PackOutput packOutput) {
        this.data = new HashMap<>(data);
        this.packOutput = packOutput;
    }

    @Override
    public CompletableFuture<?> run(CachedOutput cachedOutput) {
        this.registerData();
        return CompletableFuture.allOf(this.getData()
                .entrySet()
                .stream()
                .map(entry -> {
                    DataTarget target = entry.getKey();
                    Object content = entry.getValue();
                    Path targetPath = this.getPackOutput()
                            .getOutputFolder(target.target())
                            .resolve(target.namespace())
                            .resolve(this.resolvePathWithJsonExtension(target.path()));
                    return this.saveDataToFile(cachedOutput, content, targetPath);
                })
                .toArray(CompletableFuture<?>[]::new));
    }

    protected abstract void registerData();

    private String resolvePathWithJsonExtension(Path path) {
        return path.endsWith(JSON_FILE_EXTENSION)
                ? path.toString()
                : path + JSON_FILE_EXTENSION;
    }

    protected String minecraftPath(String pathPart, String... pathParts) {
        return ResourceLocationUtils.joinMinecraftPath(pathPart, pathParts);
    }

    protected String modPath(String pathPart, String... pathParts) {
        return ResourceLocationUtils.joinModPath(pathPart, pathParts);
    }

    protected Map<DataTarget, Object> getData() {
        return data;
    }

    protected void addData(DataTarget target, Object data) {
        this.data.put(target, data);
    }

    protected PackOutput getPackOutput() {
        return packOutput;
    }
}
