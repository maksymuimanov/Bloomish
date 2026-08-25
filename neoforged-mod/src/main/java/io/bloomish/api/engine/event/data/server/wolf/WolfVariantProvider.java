package io.bloomish.api.engine.event.data.server.wolf;

import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.world.entity.animal.WolfVariant;

public interface WolfVariantProvider {
    void addVariant(BootstrapContext<WolfVariant> context);
}
