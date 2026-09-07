package io.bloomish.api.initialization.initializer;

import io.bloomish.api.context.ObjectRegistry;
import io.bloomish.api.engine.registry.BloomishRegister;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.Collection;
import java.util.List;

public class BloomishRegisterInitializer implements ObjectRegistryInitializer {
    @Override
    public void initialize(Collection<Class<?>> classes, List<?> externalObjects, ObjectRegistry registry) {
        this.putRegister(registry, Registries.ACTIVITY, "$Activities");
        this.putRegister(registry, Registries.ARMOR_MATERIAL, "$ArmorMaterials");
        this.putRegister(registry, NeoForgeRegistries.Keys.ATTACHMENT_TYPES, "$AttachmentTypes");
        this.putRegister(registry, Registries.ATTRIBUTE, "$Attributes");
        this.putRegister(registry, NeoForgeRegistries.Keys.BIOME_MODIFIER_SERIALIZERS, "$BiomeModifierSerializers");
        this.putRegister(registry, Registries.BIOME_SOURCE, "$BiomeSources");
        this.putRegister(registry, Registries.BLOCK_ENTITY_TYPE, "$BlockEntityTypes");
        this.putRegister(registry, Registries.BLOCK_PREDICATE_TYPE, "$BlockPredicateTypes");
        this.putRegister(registry, Registries.BLOCK_STATE_PROVIDER_TYPE, "$BlockStateProviderTypes");
        registry.registerByName(BloomishRegister.createBlocks(), "$Blocks");
        this.putRegister(registry, Registries.BLOCK_TYPE, "$BlockTypes");
        this.putRegister(registry, Registries.CARVER, "$Carvers");
        this.putRegister(registry, Registries.CHUNK_GENERATOR, "$ChunkGenerators");
        this.putRegister(registry, Registries.COMMAND_ARGUMENT_TYPE, "$CommandArgumentTypes");
        this.putRegister(registry, NeoForgeRegistries.Keys.CONDITION_CODECS, "$ConditionCodecs");
        this.putRegister(registry, Registries.CREATIVE_MODE_TAB, "$CreativeModeTabs");
        this.putRegister(registry, Registries.CUSTOM_STAT, "$CustomStats");
        this.putRegister(registry, Registries.DATA_COMPONENT_TYPE, "$DataComponentTypes");
        this.putRegister(registry, Registries.DENSITY_FUNCTION_TYPE, "$DensityFunctionTypes");
        this.putRegister(registry, Registries.ENCHANTMENT_EFFECT_COMPONENT_TYPE, "$EnchantmentEffectComponentTypes");
        this.putRegister(registry, Registries.ENCHANTMENT_ENTITY_EFFECT_TYPE, "$EnchantmentEntityEffectTypes");
        this.putRegister(registry, Registries.ENCHANTMENT_LEVEL_BASED_VALUE_TYPE, "$EnchantmentLevelBasedValueTypes");
        this.putRegister(registry, Registries.ENCHANTMENT_LOCATION_BASED_EFFECT_TYPE, "$EnchantmentLocationBasedEffectTypes");
        this.putRegister(registry, Registries.ENCHANTMENT_PROVIDER_TYPE, "$EnchantmentProviderTypes");
        this.putRegister(registry, Registries.ENCHANTMENT_VALUE_EFFECT_TYPE, "$EnchantmentValueEffectTypes");
        this.putRegister(registry, NeoForgeRegistries.Keys.ENTITY_DATA_SERIALIZERS, "$EntityDataSerializers");
        this.putRegister(registry, Registries.ENTITY_SUB_PREDICATE_TYPE, "$EntitySubPredicateTypes");
        this.putRegister(registry, Registries.ENTITY_TYPE, "$EntityTypes");
        this.putRegister(registry, Registries.FEATURE_SIZE_TYPE, "$FeatureSizeTypes");
        this.putRegister(registry, Registries.FEATURE, "$Features");
        this.putRegister(registry, Registries.FLOAT_PROVIDER_TYPE, "$FloatProviderTypes");
        this.putRegister(registry, NeoForgeRegistries.Keys.FLUID_INGREDIENT_TYPES, "$FluidIngredientTypes");
        this.putRegister(registry, Registries.FLUID, "$Fluids");
        this.putRegister(registry, NeoForgeRegistries.Keys.FLUID_TYPES, "$FluidTypes");
        this.putRegister(registry, Registries.FOLIAGE_PLACER_TYPE, "$FoliagePlacerTypes");
        this.putRegister(registry, Registries.GAME_EVENT, "$GameEvents");
        this.putRegister(registry, NeoForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, "$GlobalLootModifierSerializers");
        this.putRegister(registry, Registries.HEIGHT_PROVIDER_TYPE, "$HeightProviderTypes");
        this.putRegister(registry, NeoForgeRegistries.Keys.HOLDER_SET_TYPES, "$HolderSetTypes");
        this.putRegister(registry, NeoForgeRegistries.Keys.INGREDIENT_TYPES, "$IngredientTypes");
        this.putRegister(registry, Registries.INT_PROVIDER_TYPE, "$IntProviderTypes");
        this.putRegister(registry, Registries.ITEM_SUB_PREDICATE_TYPE, "$ItemSubPredicateTypes");
        registry.registerByName(BloomishRegister.createItems(), "$Items");
        this.putRegister(registry, Registries.LOOT_CONDITION_TYPE, "$LootConditionTypes");
        this.putRegister(registry, Registries.LOOT_FUNCTION_TYPE, "$LootFunctionTypes");
        this.putRegister(registry, Registries.LOOT_NBT_PROVIDER_TYPE, "$LootNbtProviderTypes");
        this.putRegister(registry, Registries.LOOT_NUMBER_PROVIDER_TYPE, "$LootNumberProviderTypes");
        this.putRegister(registry, Registries.LOOT_POOL_ENTRY_TYPE, "$LootPoolEntryTypes");
        this.putRegister(registry, Registries.LOOT_SCORE_PROVIDER_TYPE, "$LootScoreProviderTypes");
        this.putRegister(registry, Registries.MAP_DECORATION_TYPE, "$MapDecorationTypes");
        this.putRegister(registry, Registries.MATERIAL_CONDITION, "$MaterialConditions");
        this.putRegister(registry, Registries.MATERIAL_RULE, "$MaterialRules");
        this.putRegister(registry, Registries.MEMORY_MODULE_TYPE, "$MemoryModuleTypes");
        this.putRegister(registry, Registries.MENU, "$Menus");
        this.putRegister(registry, Registries.MOB_EFFECT, "$MobEffects");
        this.putRegister(registry, Registries.NUMBER_FORMAT_TYPE, "$NumberFormatTypes");
        this.putRegister(registry, Registries.PARTICLE_TYPE, "$ParticleTypes");
        this.putRegister(registry, Registries.PLACEMENT_MODIFIER_TYPE, "$PlacementModifierTypes");
        this.putRegister(registry, Registries.POINT_OF_INTEREST_TYPE, "$PointOfInterestTypes");
        this.putRegister(registry, Registries.POSITION_SOURCE_TYPE, "$PositionSourceTypes");
        this.putRegister(registry, Registries.POS_RULE_TEST, "$PosRuleTests");
        this.putRegister(registry, Registries.POTION, "$Potions");
        this.putRegister(registry, Registries.RECIPE_SERIALIZER, "$RecipeSerializers");
        this.putRegister(registry, Registries.RECIPE_TYPE, "$RecipeTypes");
        this.putRegister(registry, Registries.ROOT_PLACER_TYPE, "$RootPlacerTypes");
        this.putRegister(registry, Registries.RULE_BLOCK_ENTITY_MODIFIER, "$RuleBlockEntityModifiers");
        this.putRegister(registry, Registries.RULE_TEST, "$RuleTests");
        this.putRegister(registry, Registries.SCHEDULE, "$Schedules");
        this.putRegister(registry, Registries.SENSOR_TYPE, "$SensorTypes");
        this.putRegister(registry, Registries.SOUND_EVENT, "$SoundEvents");
        this.putRegister(registry, Registries.STAT_TYPE, "$StatTypes");
        this.putRegister(registry, NeoForgeRegistries.Keys.STRUCTURE_MODIFIER_SERIALIZERS, "$StructureModifierSerializers");
        this.putRegister(registry, Registries.STRUCTURE_PIECE, "$StructurePieces");
        this.putRegister(registry, Registries.STRUCTURE_PLACEMENT, "$StructurePlacements");
        this.putRegister(registry, Registries.STRUCTURE_POOL_ELEMENT, "$StructurePoolElements");
        this.putRegister(registry, Registries.STRUCTURE_PROCESSOR, "$StructureProcessors");
        this.putRegister(registry, Registries.STRUCTURE_TYPE, "$StructureTypes");
        this.putRegister(registry, Registries.TREE_DECORATOR_TYPE, "$TreeDecoratorTypes");
        this.putRegister(registry, Registries.TRIGGER_TYPE, "$TriggerTypes");
        this.putRegister(registry, Registries.TRUNK_PLACER_TYPE, "$TrunkPlacerTypes");
        this.putRegister(registry, Registries.VILLAGER_PROFESSION, "$VillagerProfessions");
        this.putRegister(registry, Registries.VILLAGER_TYPE, "$VillagerTypes");
        this.putRegister(registry, Registries.INSTRUMENT, "$Instruments");
        this.putRegister(registry, Registries.CAT_VARIANT, "$CatVariants");
        this.putRegister(registry, Registries.DECORATED_POT_PATTERN, "$DecoratedPotPatterns");
        this.putRegister(registry, Registries.FROG_VARIANT, "$FrogVariants");
    }

    private <T> void putRegister(ObjectRegistry registry, ResourceKey<Registry<T>> registryKey, String name) {
        registry.registerByName(BloomishRegister.create(registryKey), name);
    }
}
