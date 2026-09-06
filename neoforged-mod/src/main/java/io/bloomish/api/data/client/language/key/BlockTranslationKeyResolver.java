package io.bloomish.api.data.client.language.key;

import io.bloomish.api.bean.Injected;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;

@Injected
public class BlockTranslationKeyResolver extends AbstractResourceKeyResolver<Block> {
    public static final String PREFIX = "block";

    @Override
    protected ResourceKey<? extends Registry<Block>> getRegistryKey() {
        return Registries.BLOCK;
    }

    @Override
    public String resolve(ResourceKey<Block> blockResourceKey) {
        return this.resolveTranslationKey(PREFIX, blockResourceKey);
    }
}
