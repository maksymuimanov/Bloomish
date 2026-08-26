package io.bloomish.api.data.server.pack;

import io.bloomish.api.data.server.banner.ApiBannerPatternProvider;
import io.bloomish.api.data.server.biome.CompoundGenerationDefinitionFacade;
import io.bloomish.api.data.server.damage.ApiDamageTypeProvider;
import io.bloomish.api.data.server.enchantment.ApiEnchantmentProvider;
import io.bloomish.api.data.server.jukebox.ApiJukeboxSongProvider;
import io.bloomish.api.data.server.painting.ApiPaintingVariantProvider;
import io.bloomish.api.data.server.trim.material.ApiTrimMaterialProvider;
import io.bloomish.api.data.server.trim.pattern.ApiTrimPatternProvider;
import io.bloomish.api.data.server.wolf.ApiWolfVariantProvider;
import io.bloomish.api.engine.context.ModContext;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class ApiDatapackProvider extends DatapackBuiltinEntriesProvider {
    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.TRIM_MATERIAL, ApiTrimMaterialProvider::bootstrap)
            .add(Registries.TRIM_PATTERN, ApiTrimPatternProvider::bootstrap)
            .add(Registries.PAINTING_VARIANT, ApiPaintingVariantProvider::bootstrap)
            .add(Registries.DAMAGE_TYPE, ApiDamageTypeProvider::bootstrap)
            .add(Registries.WOLF_VARIANT, ApiWolfVariantProvider::bootstrap)
            .add(Registries.BANNER_PATTERN, ApiBannerPatternProvider::bootstrap)
            .add(Registries.JUKEBOX_SONG, ApiJukeboxSongProvider::bootstrap)
            .add(Registries.ENCHANTMENT, ApiEnchantmentProvider::bootstrap)
            .add(Registries.CONFIGURED_FEATURE, CompoundGenerationDefinitionFacade::executeConfiguredFeatures)
            .add(Registries.PLACED_FEATURE, CompoundGenerationDefinitionFacade::executePlacedFeatures)
            .add(NeoForgeRegistries.Keys.BIOME_MODIFIERS, CompoundGenerationDefinitionFacade::executeBiomeModifiers);

    public ApiDatapackProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(ModContext.currentMod.getModId()));
    }
}
