package io.bloomish.api.data.file;

import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import org.jetbrains.annotations.NotNull;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public abstract class MultiFileProvider implements FileProvider {
    private final PackOutput output;
    private Map<FileSource, JsonSerializable> contents;

    protected MultiFileProvider(final PackOutput output) {
        this.output = output;
    }

    @Override
    @NotNull
    public CompletableFuture<?> run(@NotNull CachedOutput cachedOutput) {
        this.contents = new HashMap<>();
        this.registerFiles();
        List<CompletableFuture<?>> futures = new ArrayList<>();
        contents.forEach((source, representation) -> {
            futures.add(this.save(cachedOutput, representation, this.output.getOutputFolder(source.target())
                    .resolve(source.modId())
                    .resolve(source.path())));
        });
        return CompletableFuture.allOf(futures.toArray(CompletableFuture[]::new));
    }

    public abstract void registerFiles();

    protected final void define(FileSource fileSource, JsonSerializable representation) {
        this.contents.put(fileSource, representation);
    }

    protected CompletableFuture<?> save(final CachedOutput cache, JsonSerializable representation, final Path targetFile) {
        return DataProvider.saveStable(cache, representation.toJson(), targetFile);
    }
}