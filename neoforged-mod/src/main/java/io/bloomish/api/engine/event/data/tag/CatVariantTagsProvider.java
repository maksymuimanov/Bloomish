package io.bloomish.api.engine.event.data.tag;

import io.bloomish.api.util.TagUtils;
import net.minecraft.core.Holder;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.animal.CatVariant;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CatVariantTagsProvider extends AbstractTagsProvider<CatVariant> {
    public static final Map<String, List<Holder<? extends CatVariant>>> TAG_GENERATION_DESCRIPTIONS = new HashMap<>();
    public static final String ROOT_DIRECTORY = "tags/cat_variant/";

    public CatVariantTagsProvider(PackOutput output) {
        super(output, ROOT_DIRECTORY);
    }

    @Override
    protected Map<String, List<ResourceKey<CatVariant>>> getTagContents() {
        return TagUtils.mapTagHolderMap(TAG_GENERATION_DESCRIPTIONS);
    }
}
