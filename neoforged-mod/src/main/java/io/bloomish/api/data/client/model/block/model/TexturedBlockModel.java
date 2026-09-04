package io.bloomish.api.data.client.model.block.model;

import io.bloomish.api.data.client.model.block.texture.BlockTexture;
import io.bloomish.api.util.CollectionUtils;

import java.util.Map;
import java.util.stream.Collectors;

public record TexturedBlockModel(
        String parent,
        Map<String, String> textures
) implements BlockModel {
    public static TexturedBlockModel of(String parent, BlockTexture texture, BlockTexture... textures) {
        Map<String, String> textureMap = CollectionUtils.arrayListOf(texture, textures)
                .stream()
                .collect(Collectors.toMap(BlockTexture::getKey, BlockTexture::getValue));
        return new TexturedBlockModel(parent, textureMap);
    }
}
