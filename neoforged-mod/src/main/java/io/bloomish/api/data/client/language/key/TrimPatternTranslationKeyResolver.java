package io.bloomish.api.data.client.language.key;

import io.bloomish.api.engine.metadata.annotation.injection.Injected;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.armortrim.TrimPattern;

@Injected
public class TrimPatternTranslationKeyResolver extends AbstractResourceKeyResolver<TrimPattern> {
    public static final String PREFIX = "trim_pattern";

    @Override
    protected ResourceKey<? extends Registry<TrimPattern>> getRegistryKey() {
        return Registries.TRIM_PATTERN;
    }

    @Override
    public String resolve(ResourceKey<TrimPattern> trimPatternResourceKey) {
        return this.resolveTranslationKey(PREFIX, trimPatternResourceKey);
    }
}
