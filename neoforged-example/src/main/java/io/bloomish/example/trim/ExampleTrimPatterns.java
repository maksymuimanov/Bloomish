package io.bloomish.example.trim;

import io.bloomish.api.engine.metadata.annotation.data.language.TranslateAmericanEnglish;
import io.bloomish.api.engine.metadata.annotation.data.model.GenerateTrimPattern;
import io.bloomish.api.util.DeprecatedResourceUtils;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.armortrim.TrimPattern;

public class ExampleTrimPatterns {
    @TranslateAmericanEnglish("Example Trim Pattern")
    @GenerateTrimPattern(item = "example:example_armor_trim_smithing_template")
    public static final ResourceKey<TrimPattern> EXAMPLE_TRIM_PATTERN = DeprecatedResourceUtils.createKey(Registries.TRIM_PATTERN, "example");
}
