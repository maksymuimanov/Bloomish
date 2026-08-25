package io.bloomish.api.engine.event.data;

import com.google.gson.Gson;
import io.bloomish.api.engine.context.ModContext;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import org.jetbrains.annotations.NotNull;

import java.nio.file.Path;
import java.util.concurrent.CompletableFuture;

public interface BloomishDataProvider extends DataProvider {
    default CompletableFuture<?> saveDataToFile(CachedOutput cacheOutput, Object content, Path targetPath) {
        Gson gson = ModContext.getObject(Gson.class);
        return DataProvider.saveStable(cacheOutput, gson.toJsonTree(content), targetPath);
    }

    @NotNull
    default String getName() {
        return this.getClass().getSimpleName();
    }
}
