package io.bloomish.api.engine.event.data.server.banner;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.entity.BannerPattern;

public record BannerPatternDescription(ResourceKey<BannerPattern> pattern) {
}
