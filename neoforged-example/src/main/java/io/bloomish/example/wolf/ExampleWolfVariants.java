package io.bloomish.example.wolf;

import io.bloomish.api.engine.metadata.annotation.data.language.TranslateAmericanEnglish;
import io.bloomish.api.engine.metadata.annotation.data.model.GenerateWolfVariant;
import io.bloomish.api.util.DeprecatedResourceUtils;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.animal.WolfVariant;

public final class ExampleWolfVariants {
    @TranslateAmericanEnglish("Example Wolf Variant")
    @GenerateWolfVariant(biomeTag = "minecraft:is_nether")
    public static final ResourceKey<WolfVariant> EXAMPLE_WOLF_VARIANT = DeprecatedResourceUtils.createKey(Registries.WOLF_VARIANT, "example");
}