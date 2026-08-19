package io.bloomish.api.engine.event.data.tag;

import io.bloomish.api.util.TagUtils;
import net.minecraft.core.Holder;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BlockTagsProvider extends AbstractTagsProvider<Block> {
    public static final Map<String, List<Holder<? extends Block>>> TAG_GENERATION_DESCRIPTIONS = new HashMap<>();
    public static final String ROOT_DIRECTORY = "tags/block/";

    public BlockTagsProvider(PackOutput output) {
        super(output, ROOT_DIRECTORY);
    }

    @Override
    protected Map<String, List<ResourceKey<Block>>> getTagContents() {
        return TagUtils.mapTagHolderMap(TAG_GENERATION_DESCRIPTIONS);
    }
}
