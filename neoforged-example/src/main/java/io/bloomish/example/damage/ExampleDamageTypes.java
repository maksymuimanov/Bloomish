package io.bloomish.example.damage;

import io.bloomish.api.engine.metadata.annotation.data.GenerateDamageType;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateAmericanEnglish;
import io.bloomish.api.engine.metadata.annotation.data.language.TranslateMultiple;
import io.bloomish.api.util.DeprecatedResourceUtils;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.damagesource.DamageType;

public final class ExampleDamageTypes {
    @TranslateMultiple(americanEnglish = {
            @TranslateAmericanEnglish("Example Damage"),
            @TranslateAmericanEnglish(value = "Killed by {2this}", prefix = "death.attack")
    })
    @GenerateDamageType
    public static final ResourceKey<DamageType> EXAMPLE_DAMAGE_TYPE = DeprecatedResourceUtils.createKey(Registries.DAMAGE_TYPE, "example");
}
