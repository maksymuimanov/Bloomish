package io.bloomish.api.engine.initialization.initializer;

import io.bloomish.api.engine.context.ObjectRegistry;
import io.bloomish.api.engine.registry.TemporalRegister;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.Collection;
import java.util.List;

public class TemporalRegisterPoolInitializer implements ObjectPoolInitializer {
    @Override
    public void initialize(Collection<Class<?>> classes, List<?> externalObjects, ObjectRegistry objectRegistry) {
        this.putRegister(objectRegistry, "$Activities", Registries.ACTIVITY);
        this.putRegister(objectRegistry, "$ArmorMaterials", Registries.ARMOR_MATERIAL);
        this.putRegister(objectRegistry, "$AttachmentTypes", NeoForgeRegistries.Keys.ATTACHMENT_TYPES);
        this.putRegister(objectRegistry, "$Attributes", Registries.ATTRIBUTE);
        this.putRegister(objectRegistry, "$BiomeModifierSerializers", NeoForgeRegistries.Keys.BIOME_MODIFIER_SERIALIZERS);
        this.putRegister(objectRegistry, "$BiomeSources", Registries.BIOME_SOURCE);
        this.putRegister(objectRegistry, "$BlockEntityTypes", Registries.BLOCK_ENTITY_TYPE);
        this.putRegister(objectRegistry, "$BlockPredicateTypes", Registries.BLOCK_PREDICATE_TYPE);
        this.putRegister(objectRegistry, "$BlockStateProviderTypes", Registries.BLOCK_STATE_PROVIDER_TYPE);
        objectRegistry.register("$Blocks", TemporalRegister.createBlocks());
        this.putRegister(objectRegistry, "$BlockTypes", Registries.BLOCK_TYPE);
        this.putRegister(objectRegistry, "$Carvers", Registries.CARVER);
        this.putRegister(objectRegistry, "$ChunkGenerators", Registries.CHUNK_GENERATOR);
        this.putRegister(objectRegistry, "$CommandArgumentTypes", Registries.COMMAND_ARGUMENT_TYPE);
        this.putRegister(objectRegistry, "$ConditionCodecs", NeoForgeRegistries.Keys.CONDITION_CODECS);
        this.putRegister(objectRegistry, "$CreativeModeTabs", Registries.CREATIVE_MODE_TAB);
        this.putRegister(objectRegistry, "$CustomStats", Registries.CUSTOM_STAT);
        this.putRegister(objectRegistry, "$DataComponentTypes", Registries.DATA_COMPONENT_TYPE);
        this.putRegister(objectRegistry, "$DensityFunctionTypes", Registries.DENSITY_FUNCTION_TYPE);
        this.putRegister(objectRegistry, "$EnchantmentEffectComponentTypes", Registries.ENCHANTMENT_EFFECT_COMPONENT_TYPE);
        this.putRegister(objectRegistry, "$EnchantmentEntityEffectTypes", Registries.ENCHANTMENT_ENTITY_EFFECT_TYPE);
        this.putRegister(objectRegistry, "$EnchantmentLevelBasedValueTypes", Registries.ENCHANTMENT_LEVEL_BASED_VALUE_TYPE);
        this.putRegister(objectRegistry, "$EnchantmentLocationBasedEffectTypes", Registries.ENCHANTMENT_LOCATION_BASED_EFFECT_TYPE);
        this.putRegister(objectRegistry, "$EnchantmentProviderTypes", Registries.ENCHANTMENT_PROVIDER_TYPE);
        this.putRegister(objectRegistry, "$EnchantmentValueEffectTypes", Registries.ENCHANTMENT_VALUE_EFFECT_TYPE);
        this.putRegister(objectRegistry, "$EntityDataSerializers", NeoForgeRegistries.Keys.ENTITY_DATA_SERIALIZERS);
        this.putRegister(objectRegistry, "$EntitySubPredicateTypes", Registries.ENTITY_SUB_PREDICATE_TYPE);
        this.putRegister(objectRegistry, "$EntityTypes", Registries.ENTITY_TYPE);
        this.putRegister(objectRegistry, "$FeatureSizeTypes", Registries.FEATURE_SIZE_TYPE);
        this.putRegister(objectRegistry, "$Features", Registries.FEATURE);
        this.putRegister(objectRegistry, "$FloatProviderTypes", Registries.FLOAT_PROVIDER_TYPE);
        this.putRegister(objectRegistry, "$FluidIngredientTypes", NeoForgeRegistries.Keys.FLUID_INGREDIENT_TYPES);
        this.putRegister(objectRegistry, "$Fluids", Registries.FLUID);
        this.putRegister(objectRegistry, "$FluidTypes", NeoForgeRegistries.Keys.FLUID_TYPES);
        this.putRegister(objectRegistry, "$FoliagePlacerTypes", Registries.FOLIAGE_PLACER_TYPE);
        this.putRegister(objectRegistry, "$GameEvents", Registries.GAME_EVENT);
        this.putRegister(objectRegistry, "$GlobalLootModifierSerializers", NeoForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS);
        this.putRegister(objectRegistry, "$HeightProviderTypes", Registries.HEIGHT_PROVIDER_TYPE);
        this.putRegister(objectRegistry, "$HolderSetTypes", NeoForgeRegistries.Keys.HOLDER_SET_TYPES);
        this.putRegister(objectRegistry, "$IngredientTypes", NeoForgeRegistries.Keys.INGREDIENT_TYPES);
        this.putRegister(objectRegistry, "$IntProviderTypes", Registries.INT_PROVIDER_TYPE);
        this.putRegister(objectRegistry, "$ItemSubPredicateTypes", Registries.ITEM_SUB_PREDICATE_TYPE);
        objectRegistry.register("$Items", TemporalRegister.createItems());
        this.putRegister(objectRegistry, "$LootConditionTypes", Registries.LOOT_CONDITION_TYPE);
        this.putRegister(objectRegistry, "$LootFunctionTypes", Registries.LOOT_FUNCTION_TYPE);
        this.putRegister(objectRegistry, "$LootNbtProviderTypes", Registries.LOOT_NBT_PROVIDER_TYPE);
        this.putRegister(objectRegistry, "$LootNumberProviderTypes", Registries.LOOT_NUMBER_PROVIDER_TYPE);
        this.putRegister(objectRegistry, "$LootPoolEntryTypes", Registries.LOOT_POOL_ENTRY_TYPE);
        this.putRegister(objectRegistry, "$LootScoreProviderTypes", Registries.LOOT_SCORE_PROVIDER_TYPE);
        this.putRegister(objectRegistry, "$MapDecorationTypes", Registries.MAP_DECORATION_TYPE);
        this.putRegister(objectRegistry, "$MaterialConditions", Registries.MATERIAL_CONDITION);
        this.putRegister(objectRegistry, "$MaterialRules", Registries.MATERIAL_RULE);
        this.putRegister(objectRegistry, "$MemoryModuleTypes", Registries.MEMORY_MODULE_TYPE);
        this.putRegister(objectRegistry, "$Menus", Registries.MENU);
        this.putRegister(objectRegistry, "$MobEffects", Registries.MOB_EFFECT);
        this.putRegister(objectRegistry, "$NumberFormatTypes", Registries.NUMBER_FORMAT_TYPE);
        this.putRegister(objectRegistry, "$ParticleTypes", Registries.PARTICLE_TYPE);
        this.putRegister(objectRegistry, "$PlacementModifierTypes", Registries.PLACEMENT_MODIFIER_TYPE);
        this.putRegister(objectRegistry, "$PointOfInterestTypes", Registries.POINT_OF_INTEREST_TYPE);
        this.putRegister(objectRegistry, "$PositionSourceTypes", Registries.POSITION_SOURCE_TYPE);
        this.putRegister(objectRegistry, "$PosRuleTests", Registries.POS_RULE_TEST);
        this.putRegister(objectRegistry, "$Potions", Registries.POTION);
        this.putRegister(objectRegistry, "$RecipeSerializers", Registries.RECIPE_SERIALIZER);
        this.putRegister(objectRegistry, "$RecipeTypes", Registries.RECIPE_TYPE);
        this.putRegister(objectRegistry, "$RootPlacerTypes", Registries.ROOT_PLACER_TYPE);
        this.putRegister(objectRegistry, "$RuleBlockEntityModifiers", Registries.RULE_BLOCK_ENTITY_MODIFIER);
        this.putRegister(objectRegistry, "$RuleTests", Registries.RULE_TEST);
        this.putRegister(objectRegistry, "$Schedules", Registries.SCHEDULE);
        this.putRegister(objectRegistry, "$SensorTypes", Registries.SENSOR_TYPE);
        this.putRegister(objectRegistry, "$SoundEvents", Registries.SOUND_EVENT);
        this.putRegister(objectRegistry, "$StatTypes", Registries.STAT_TYPE);
        this.putRegister(objectRegistry, "$StructureModifierSerializers", NeoForgeRegistries.Keys.STRUCTURE_MODIFIER_SERIALIZERS);
        this.putRegister(objectRegistry, "$StructurePieces", Registries.STRUCTURE_PIECE);
        this.putRegister(objectRegistry, "$StructurePlacements", Registries.STRUCTURE_PLACEMENT);
        this.putRegister(objectRegistry, "$StructurePoolElements", Registries.STRUCTURE_POOL_ELEMENT);
        this.putRegister(objectRegistry, "$StructureProcessors", Registries.STRUCTURE_PROCESSOR);
        this.putRegister(objectRegistry, "$StructureTypes", Registries.STRUCTURE_TYPE);
        this.putRegister(objectRegistry, "$TreeDecoratorTypes", Registries.TREE_DECORATOR_TYPE);
        this.putRegister(objectRegistry, "$TriggerTypes", Registries.TRIGGER_TYPE);
        this.putRegister(objectRegistry, "$TrunkPlacerTypes", Registries.TRUNK_PLACER_TYPE);
        this.putRegister(objectRegistry, "$VillagerProfessions", Registries.VILLAGER_PROFESSION);
        this.putRegister(objectRegistry, "$VillagerTypes", Registries.VILLAGER_TYPE);
        this.putRegister(objectRegistry, "$Instruments", Registries.INSTRUMENT);
        this.putRegister(objectRegistry, "$CatVariants", Registries.CAT_VARIANT);
        this.putRegister(objectRegistry, "$DecoratedPotPatterns", Registries.DECORATED_POT_PATTERN);
        this.putRegister(objectRegistry, "$FrogVariants", Registries.FROG_VARIANT);
    }

    private <T> void putRegister(ObjectRegistry objectRegistry, String name, ResourceKey<Registry<T>> registry) {
        objectRegistry.register(name, TemporalRegister.create(registry));
    }
}
