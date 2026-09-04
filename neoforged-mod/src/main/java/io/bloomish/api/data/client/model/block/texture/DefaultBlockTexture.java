package io.bloomish.api.data.client.model.block.texture;

import io.bloomish.api.util.RegistryPathUtils;
import io.bloomish.api.util.ResourceLocationUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;

public record DefaultBlockTexture(
        String value
) implements BlockTexture {
    private static final String TEXTURE = "texture";

    public static DefaultBlockTexture ofBlock(Block block) {
        String texturePath = RegistryPathUtils.findBlockNamespacedPath(block, BLOCK_PATH);
        return new DefaultBlockTexture(texturePath);
    }

    public static DefaultBlockTexture ofFullPath(String fullPath) {
        ResourceLocation location = ResourceLocationUtils.parseLocation(fullPath);
        String fullBlockPath = ResourceLocationUtils.joinNamespacedPath(location, BLOCK_PATH);
        return new DefaultBlockTexture(fullBlockPath);
    }

    @Override
    public String getKey() {
        return TEXTURE;
    }

    @Override
    public String getValue() {
        return value;
    }
}
