package io.bloomish.example.cat;

import io.bloomish.api.engine.context.DefaultObjectRegistry;
import io.bloomish.api.engine.metadata.annotation.data.tag.AddCatVariantTag;
import io.bloomish.api.engine.registry.factory.CatVariantFactory;
import net.minecraft.world.entity.animal.CatVariant;
import net.neoforged.neoforge.registries.DeferredHolder;

public final class ExampleCatVariants {
    private static final CatVariantFactory CAT_VARIANT_FACTORY = DefaultObjectRegistry.getFromInstance(CatVariantFactory.class);

    @AddCatVariantTag("minecraft:default_spawns")
    public static final DeferredHolder<CatVariant, CatVariant> EXAMPLE = CAT_VARIANT_FACTORY.create("example");
}
