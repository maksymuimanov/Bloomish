package io.bloomish.example.trim;

import io.bloomish.api.engine.metadata.annotation.data.GenerateTrimMaterial;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateAmericanEnglish;
import io.bloomish.api.util.DeprecatedResourceUtils;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.armortrim.TrimMaterial;

public final class ExampleTrimMaterials {
    @TranslateAmericanEnglish("Example Trim Material")
    @GenerateTrimMaterial(item = "example:example_ingot", color = "#829499", itemModelIndex = 0.2F)
    public static final ResourceKey<TrimMaterial> EXAMPLE_TRIM_MATERIAL = DeprecatedResourceUtils.createKey(Registries.TRIM_MATERIAL, "example");

}
