package io.bloomish.api.data.client.atlas;

import io.bloomish.api.channel.DataChannels;
import io.bloomish.api.channel.ValueChannelBus;
import io.bloomish.api.engine.metadata.annotation.injection.Injected;
import io.bloomish.api.util.ResourceKeyUtils;
import io.bloomish.api.util.ResourceLocationUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.armortrim.TrimPattern;
import net.minecraft.world.item.armortrim.TrimPatterns;

import java.util.ArrayList;
import java.util.List;

@Injected
public class DefaultAtlasArmorTrimPatternCollector implements AtlasArmorTrimPatternCollector {
    private static final String TRIMS_MODELS_ARMOR_PATH = "trims/models/armor/";
    private static final String LEGGINGS_SUFFIX = "_leggings";
    private final List<String> trimPatterns;
    private final ValueChannelBus channelBus;

    public DefaultAtlasArmorTrimPatternCollector(ValueChannelBus channelBus) {
        this.channelBus = channelBus;
        this.trimPatterns = new ArrayList<>();
        this.initializeDefaultPatterns();
    }

    private void initializeDefaultPatterns() {
        ResourceKeyUtils.<TrimPattern>extractResourceKeys(TrimPatterns.class)
                .map(ResourceKey::location)
                .map(ResourceLocation::getPath)
                .forEach(this::addPattern);
    }

    @Override
    public List<String> collectPatterns() {
        this.channelBus.<ResourceLocation>forEachDrain(DataChannels.ATLAS_ARMOR_TRIM_PROVIDER_TRIM_PATTERNS, location -> {
            String path = ResourceLocationUtils.joinNamespacedPath(location, TRIMS_MODELS_ARMOR_PATH);
            this.addPattern(path);
        });
        return List.copyOf(this.trimPatterns);
    }

    private void addPattern(String path) {
        String patternPath = TRIMS_MODELS_ARMOR_PATH + path;
        this.trimPatterns.add(patternPath);
        this.trimPatterns.add(patternPath + LEGGINGS_SUFFIX);
    }
}
