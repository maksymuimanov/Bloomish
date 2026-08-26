package io.bloomish.api.data.server.wolf;

import io.bloomish.api.core.collection.TemporalQueue;
import io.bloomish.api.data.preparer.tag.BiomeTagDynamicPreparer;
import io.bloomish.api.util.DeprecatedResourceUtils;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.animal.WolfVariant;
import net.minecraft.world.level.biome.Biome;

import java.util.Queue;

public class ApiWolfVariantProvider implements WolfVariantProvider {
    public static final Queue<WolfVariantDescription> VARIANTS = new TemporalQueue<>();
    public static final String ENTITY_WOLF_PATH = "entity/wolf/";
    public static final String TAME_SUFFIX = "_tame";
    public static final String ANGRY_SUFFIX = "_angry";

    @Override
    public void addVariant(BootstrapContext<WolfVariant> context) {
        HolderGetter<Biome> biomes = context.lookup(Registries.BIOME);
        VARIANTS.forEach(description -> {
            ResourceKey<WolfVariant> variant = description.variant();
            String id = DeprecatedResourceUtils.mapId(DeprecatedResourceUtils.getResourceId(variant), ENTITY_WOLF_PATH::concat);
            ResourceLocation defaultTexture = DeprecatedResourceUtils.parse(id);
            ResourceLocation tamedTexture = DeprecatedResourceUtils.parse(id + TAME_SUFFIX);
            ResourceLocation angryTexture = DeprecatedResourceUtils.parse(id + ANGRY_SUFFIX);
            TagKey<Biome> spawnBiome = BiomeTagDynamicPreparer.BIOME_TAGS.get(description.biomeTag());
            context.register(variant, new WolfVariant(defaultTexture, tamedTexture, angryTexture, biomes.getOrThrow(spawnBiome)));
        });
    }

    public static void bootstrap(BootstrapContext<WolfVariant> context) {
        WolfVariantProvider provider = new ApiWolfVariantProvider();
        provider.addVariant(context);
    }
}
