package io.bloomish.api.data.client.language.key;

import io.bloomish.api.engine.metadata.annotation.injection.Injected;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.decoration.PaintingVariant;

@Injected
public class PaintingVariantTranslationKeyResolver extends AbstractResourceKeyResolver<PaintingVariant> {
    public static final String PREFIX = "painting";
    public static final String TITLE_SUFFIX = ".title";

    @Override
    protected ResourceKey<? extends Registry<PaintingVariant>> getRegistryKey() {
        return Registries.PAINTING_VARIANT;
    }

    @Override
    public String resolve(ResourceKey<PaintingVariant> paintingVariantResourceKey) {
        return this.resolveTranslationKey(PREFIX, paintingVariantResourceKey) + TITLE_SUFFIX;
    }
}
