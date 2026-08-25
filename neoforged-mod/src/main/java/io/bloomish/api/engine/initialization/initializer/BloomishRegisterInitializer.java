package io.bloomish.api.engine.initialization.initializer;

import io.bloomish.api.engine.context.ObjectRegistry;
import io.bloomish.api.engine.initialization.ObjectRegistryInitializer;
import io.bloomish.api.engine.registry.BloomishRegister;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.Collection;
import java.util.List;

public class BloomishRegisterInitializer implements ObjectRegistryInitializer {
    @Override
    public void initialize(Collection<Class<?>> classes, List<?> externalObjects, ObjectRegistry objectRegistry) {
        this.putRegister(objectRegistry, Registries.ACTIVITY, "$Activities");
        this.putRegister(objectRegistry, Registries.ARMOR_MATERIAL, "$ArmorMaterials");
        this.putRegister(objectRegistry, NeoForgeRegistries.Keys.ATTACHMENT_TYPES, "$AttachmentTypes");
        this.putRegister(objectRegistry, Registries.ATTRIBUTE, "$Attributes");
        this.putRegister(objectRegistry, NeoForgeRegistries.Keys.BIOME_MODIFIER_SERIALIZERS, "$BiomeModifierSerializers");
        this.putRegister(objectRegistry, Registries.BIOME_SOURCE, "$BiomeSources");
        this.putRegister(objectRegistry, Registries.BLOCK_ENTITY_TYPE, "$BlockEntityTypes");
        this.putRegister(objectRegistry, Registries.BLOCK_PREDICATE_TYPE, "$BlockPredicateTypes");
        this.putRegister(objectRegistry, Registries.BLOCK_STATE_PROVIDER_TYPE, "$BlockStateProviderTypes");
        objectRegistry.registerValueByName(BloomishRegister.createBlocks(), "$Blocks");
        this.putRegister(objectRegistry, Registries.BLOCK_TYPE, "$BlockTypes");
        this.putRegister(objectRegistry, Registries.CARVER, "$Carvers");
        this.putRegister(objectRegistry, Registries.CHUNK_GENERATOR, "$ChunkGenerators");
        this.putRegister(objectRegistry, Registries.COMMAND_ARGUMENT_TYPE, "$CommandArgumentTypes");
        this.putRegister(objectRegistry, NeoForgeRegistries.Keys.CONDITION_CODECS, "$ConditionCodecs");
        this.putRegister(objectRegistry, Registries.CREATIVE_MODE_TAB, "$CreativeModeTabs");
        this.putRegister(objectRegistry, Registries.CUSTOM_STAT, "$CustomStats");
        this.putRegister(objectRegistry, Registries.DATA_COMPONENT_TYPE, "$DataComponentTypes");
        this.putRegister(objectRegistry, Registries.DENSITY_FUNCTION_TYPE, "$DensityFunctionTypes");
        this.putRegister(objectRegistry, Registries.ENCHANTMENT_EFFECT_COMPONENT_TYPE, "$EnchantmentEffectComponentTypes");
        this.putRegister(objectRegistry, Registries.ENCHANTMENT_ENTITY_EFFECT_TYPE, "$EnchantmentEntityEffectTypes");
        this.putRegister(objectRegistry, Registries.ENCHANTMENT_LEVEL_BASED_VALUE_TYPE, "$EnchantmentLevelBasedValueTypes");
        this.putRegister(objectRegistry, Registries.ENCHANTMENT_LOCATION_BASED_EFFECT_TYPE, "$EnchantmentLocationBasedEffectTypes");
        this.putRegister(objectRegistry, Registries.ENCHANTMENT_PROVIDER_TYPE, "$EnchantmentProviderTypes");
        this.putRegister(objectRegistry, Registries.ENCHANTMENT_VALUE_EFFECT_TYPE, "$EnchantmentValueEffectTypes");
        this.putRegister(objectRegistry, NeoForgeRegistries.Keys.ENTITY_DATA_SERIALIZERS, "$EntityDataSerializers");
        this.putRegister(objectRegistry, Registries.ENTITY_SUB_PREDICATE_TYPE, "$EntitySubPredicateTypes");
        this.putRegister(objectRegistry, Registries.ENTITY_TYPE, "$EntityTypes");
        this.putRegister(objectRegistry, Registries.FEATURE_SIZE_TYPE, "$FeatureSizeTypes");
        this.putRegister(objectRegistry, Registries.FEATURE, "$Features");
        this.putRegister(objectRegistry, Registries.FLOAT_PROVIDER_TYPE, "$FloatProviderTypes");
        this.putRegister(objectRegistry, NeoForgeRegistries.Keys.FLUID_INGREDIENT_TYPES, "$FluidIngredientTypes");
        this.putRegister(objectRegistry, Registries.FLUID, "$Fluids");
        this.putRegister(objectRegistry, NeoForgeRegistries.Keys.FLUID_TYPES, "$FluidTypes");
        this.putRegister(objectRegistry, Registries.FOLIAGE_PLACER_TYPE, "$FoliagePlacerTypes");
        this.putRegister(objectRegistry, Registries.GAME_EVENT, "$GameEvents");
        this.putRegister(objectRegistry, NeoForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, "$GlobalLootModifierSerializers");
        this.putRegister(objectRegistry, Registries.HEIGHT_PROVIDER_TYPE, "$HeightProviderTypes");
        this.putRegister(objectRegistry, NeoForgeRegistries.Keys.HOLDER_SET_TYPES, "$HolderSetTypes");
        this.putRegister(objectRegistry, NeoForgeRegistries.Keys.INGREDIENT_TYPES, "$IngredientTypes");
        this.putRegister(objectRegistry, Registries.INT_PROVIDER_TYPE, "$IntProviderTypes");
        this.putRegister(objectRegistry, Registries.ITEM_SUB_PREDICATE_TYPE, "$ItemSubPredicateTypes");
        objectRegistry.registerValueByName(BloomishRegister.createItems(), "$Items");
        this.putRegister(objectRegistry, Registries.LOOT_CONDITION_TYPE, "$LootConditionTypes");
        this.putRegister(objectRegistry, Registries.LOOT_FUNCTION_TYPE, "$LootFunctionTypes");
        this.putRegister(objectRegistry, Registries.LOOT_NBT_PROVIDER_TYPE, "$LootNbtProviderTypes");
        this.putRegister(objectRegistry, Registries.LOOT_NUMBER_PROVIDER_TYPE, "$LootNumberProviderTypes");
        this.putRegister(objectRegistry, Registries.LOOT_POOL_ENTRY_TYPE, "$LootPoolEntryTypes");
        this.putRegister(objectRegistry, Registries.LOOT_SCORE_PROVIDER_TYPE, "$LootScoreProviderTypes");
        this.putRegister(objectRegistry, Registries.MAP_DECORATION_TYPE, "$MapDecorationTypes");
        this.putRegister(objectRegistry, Registries.MATERIAL_CONDITION, "$MaterialConditions");
        this.putRegister(objectRegistry, Registries.MATERIAL_RULE, "$MaterialRules");
        this.putRegister(objectRegistry, Registries.MEMORY_MODULE_TYPE, "$MemoryModuleTypes");
        this.putRegister(objectRegistry, Registries.MENU, "$Menus");
        this.putRegister(objectRegistry, Registries.MOB_EFFECT, "$MobEffects");
        this.putRegister(objectRegistry, Registries.NUMBER_FORMAT_TYPE, "$NumberFormatTypes");
        this.putRegister(objectRegistry, Registries.PARTICLE_TYPE, "$ParticleTypes");
        this.putRegister(objectRegistry, Registries.PLACEMENT_MODIFIER_TYPE, "$PlacementModifierTypes");
        this.putRegister(objectRegistry, Registries.POINT_OF_INTEREST_TYPE, "$PointOfInterestTypes");
        this.putRegister(objectRegistry, Registries.POSITION_SOURCE_TYPE, "$PositionSourceTypes");
        this.putRegister(objectRegistry, Registries.POS_RULE_TEST, "$PosRuleTests");
        this.putRegister(objectRegistry, Registries.POTION, "$Potions");
        this.putRegister(objectRegistry, Registries.RECIPE_SERIALIZER, "$RecipeSerializers");
        this.putRegister(objectRegistry, Registries.RECIPE_TYPE, "$RecipeTypes");
        this.putRegister(objectRegistry, Registries.ROOT_PLACER_TYPE, "$RootPlacerTypes");
        this.putRegister(objectRegistry, Registries.RULE_BLOCK_ENTITY_MODIFIER, "$RuleBlockEntityModifiers");
        this.putRegister(objectRegistry, Registries.RULE_TEST, "$RuleTests");
        this.putRegister(objectRegistry, Registries.SCHEDULE, "$Schedules");
        this.putRegister(objectRegistry, Registries.SENSOR_TYPE, "$SensorTypes");
        this.putRegister(objectRegistry, Registries.SOUND_EVENT, "$SoundEvents");
        this.putRegister(objectRegistry, Registries.STAT_TYPE, "$StatTypes");
        this.putRegister(objectRegistry, NeoForgeRegistries.Keys.STRUCTURE_MODIFIER_SERIALIZERS, "$StructureModifierSerializers");
        this.putRegister(objectRegistry, Registries.STRUCTURE_PIECE, "$StructurePieces");
        this.putRegister(objectRegistry, Registries.STRUCTURE_PLACEMENT, "$StructurePlacements");
        this.putRegister(objectRegistry, Registries.STRUCTURE_POOL_ELEMENT, "$StructurePoolElements");
        this.putRegister(objectRegistry, Registries.STRUCTURE_PROCESSOR, "$StructureProcessors");
        this.putRegister(objectRegistry, Registries.STRUCTURE_TYPE, "$StructureTypes");
        this.putRegister(objectRegistry, Registries.TREE_DECORATOR_TYPE, "$TreeDecoratorTypes");
        this.putRegister(objectRegistry, Registries.TRIGGER_TYPE, "$TriggerTypes");
        this.putRegister(objectRegistry, Registries.TRUNK_PLACER_TYPE, "$TrunkPlacerTypes");
        this.putRegister(objectRegistry, Registries.VILLAGER_PROFESSION, "$VillagerProfessions");
        this.putRegister(objectRegistry, Registries.VILLAGER_TYPE, "$VillagerTypes");
        this.putRegister(objectRegistry, Registries.INSTRUMENT, "$Instruments");
        this.putRegister(objectRegistry, Registries.CAT_VARIANT, "$CatVariants");
        this.putRegister(objectRegistry, Registries.DECORATED_POT_PATTERN, "$DecoratedPotPatterns");
        this.putRegister(objectRegistry, Registries.FROG_VARIANT, "$FrogVariants");
    }

    private <T> void putRegister(ObjectRegistry objectRegistry, ResourceKey<Registry<T>> registry, String name) {
        objectRegistry.registerValueByName(BloomishRegister.create(registry), name);
    }
}
