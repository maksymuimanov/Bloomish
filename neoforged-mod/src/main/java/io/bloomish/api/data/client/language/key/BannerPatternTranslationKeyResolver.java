package io.bloomish.api.data.client.language.key;

import io.bloomish.api.engine.metadata.annotation.injection.Injected;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.entity.BannerPattern;

@Injected
public class BannerPatternTranslationKeyResolver extends AbstractResourceKeyResolver<BannerPattern> {
    public static final String PREFIX = "block.minecraft.banner.";

    @Override
    protected ResourceKey<? extends Registry<BannerPattern>> getRegistryKey() {
        return Registries.BANNER_PATTERN;
    }

    @Override
    public String resolve(ResourceKey<BannerPattern> bannerPatternResourceKey) {
        return PREFIX + bannerPatternResourceKey.location().toShortLanguageKey();
    }
}
