package io.bloomish.api.data.server.painting;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.decoration.PaintingVariant;

public record PaintingVariantDescription(ResourceKey<PaintingVariant> paintingVariant, int width, int height) {
}
