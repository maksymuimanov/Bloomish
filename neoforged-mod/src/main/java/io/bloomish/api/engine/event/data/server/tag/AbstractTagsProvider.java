package io.bloomish.api.engine.event.data.server.tag;

import io.bloomish.api.engine.event.data.file.FileSource;
import io.bloomish.api.engine.event.data.file.MultiFileProvider;
import io.bloomish.api.engine.event.data.json.ResourceLocationsJson;
import io.bloomish.api.util.DeprecatedResourceUtils;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;

import java.util.List;
import java.util.Map;

public abstract class AbstractTagsProvider<T> extends MultiFileProvider {
    private final String rootDirectory;

    public AbstractTagsProvider(PackOutput output, String rootDirectory) {
        super(output);
        this.rootDirectory = rootDirectory;
    }

    @Override
    public void registerFiles() {
        Map<String, List<ResourceKey<T>>> tagContents = this.getTagContents();
        tagContents.forEach((tag, keys) -> {
            ResourceLocation tagLocation = DeprecatedResourceUtils.parse(tag);
            FileSource fileSource = new FileSource(PackOutput.Target.DATA_PACK, tagLocation.getNamespace(), this.getRootDirectory() + tagLocation.getPath() + JSON);
            List<ResourceLocation> locations = keys.stream()
                    .map(ResourceKey::location)
                    .toList();
            JsonSerializable representation = new ResourceLocationsJson(locations);
            this.define(fileSource, representation);
        });
        tagContents.clear();
    }

    protected abstract Map<String, List<ResourceKey<T>>> getTagContents();

    public String getRootDirectory() {
        return rootDirectory;
    }
}
