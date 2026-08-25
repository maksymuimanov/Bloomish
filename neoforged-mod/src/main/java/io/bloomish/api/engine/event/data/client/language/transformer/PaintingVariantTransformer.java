package io.bloomish.api.engine.event.data.client.language.transformer;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.decoration.PaintingVariant;

public class PaintingVariantTransformer implements KeyTransformer<ResourceKey<PaintingVariant>> {
    public static final String PREFIX = "painting";
    public static final String TITLE_SUFFIX = ".title";

    @Override
    public String transform(ResourceKey<PaintingVariant> paintingVariant) {
        return this.transformResourceKey(PREFIX, paintingVariant) + TITLE_SUFFIX;
    }
}
