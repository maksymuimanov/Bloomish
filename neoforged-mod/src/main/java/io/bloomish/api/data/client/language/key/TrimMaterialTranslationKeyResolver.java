package io.bloomish.api.data.client.language.key;

import io.bloomish.api.engine.metadata.annotation.injection.Injected;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.armortrim.TrimMaterial;

@Injected
public class TrimMaterialTranslationKeyResolver extends AbstractResourceKeyResolver<TrimMaterial> {
    public static final String PREFIX = "trim_material";

    @Override
    protected ResourceKey<? extends Registry<TrimMaterial>> getRegistryKey() {
        return Registries.TRIM_MATERIAL;
    }

    @Override
    public String resolve(ResourceKey<TrimMaterial> trimMaterialResourceKey) {
        return this.resolveTranslationKey(PREFIX, trimMaterialResourceKey);
    }
}
