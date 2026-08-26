package io.bloomish.api.data.server.banner;

import io.bloomish.api.core.collection.TemporalQueue;
import io.bloomish.api.data.client.language.key.BannerPatternTranslationKeyResolver;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.entity.BannerPattern;

import java.util.Queue;

public class ApiBannerPatternProvider implements BannerPatternProvider {
    public static final Queue<BannerPatternDescription> PATTERNS = new TemporalQueue<>();

    @Override
    public void addVariant(BootstrapContext<BannerPattern> context) {
        PATTERNS.forEach(description -> {
            ResourceKey<BannerPattern> pattern = description.pattern();
            ResourceLocation location = pattern.location();
            context.register(pattern, new BannerPattern(location, BannerPatternTranslationKeyResolver.PREFIX + location.toShortLanguageKey()));
        });
    }

    public static void bootstrap(BootstrapContext<BannerPattern> context) {
        BannerPatternProvider provider = new ApiBannerPatternProvider();
        provider.addVariant(context);
    }
}
