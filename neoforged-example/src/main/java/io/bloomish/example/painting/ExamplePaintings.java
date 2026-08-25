package io.bloomish.example.painting;

import io.bloomish.api.engine.metadata.annotation.data.language.TranslateAmericanEnglish;
import io.bloomish.api.engine.metadata.annotation.data.model.GeneratePainting;
import io.bloomish.api.util.DeprecatedResourceUtils;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.decoration.PaintingVariant;

public final class ExamplePaintings {
    @GeneratePainting
    @TranslateAmericanEnglish("Example Painting")
    private static final ResourceKey<PaintingVariant> EXAMPLE = DeprecatedResourceUtils.createKey(Registries.PAINTING_VARIANT, "example");
}
