package io.bloomish.api.data.client.language.key;

import io.bloomish.api.engine.metadata.annotation.injection.Injected;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.stats.StatType;

@Injected
public class StatTypeTranslationKeyResolver extends AbstractResourceKeyResolver<StatType<?>> {
    public static final String PREFIX = "stat_type";

    @Override
    protected ResourceKey<? extends Registry<StatType<?>>> getRegistryKey() {
        return Registries.STAT_TYPE;
    }

    @Override
    public String resolve(ResourceKey<StatType<?>> statTypeResourceKey) {
        return this.resolveTranslationKey(PREFIX, statTypeResourceKey);
    }
}
