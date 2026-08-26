package io.bloomish.api.data.server.painting;

import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.world.entity.decoration.PaintingVariant;

public interface PaintingVariantProvider {
    void registerPaintingVariant(BootstrapContext<PaintingVariant> context);
}
