package io.bloomish.api.engine.event.data.modifier;

import io.bloomish.api.common.loot.AddItemModifier;
import io.bloomish.api.core.collection.TemporalQueue;
import io.bloomish.api.engine.context.EngineContext;
import io.bloomish.api.util.ResourceUtils;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.neoforged.neoforge.common.data.GlobalLootModifierProvider;
import net.neoforged.neoforge.common.loot.LootTableIdCondition;

import java.util.Queue;
import java.util.concurrent.CompletableFuture;

public class ApiGlobalLootModifierProvider extends GlobalLootModifierProvider {
    public static final Queue<ChestModifierDescription> CHEST_MODIFIER_DESCRIPTIONS = new TemporalQueue<>();

    public ApiGlobalLootModifierProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, EngineContext.currentMod.getModId());
    }

    @Override
    protected void start() {
        CHEST_MODIFIER_DESCRIPTIONS.forEach(description -> {
            add(description.getModifierName(), new AddItemModifier(new LootItemCondition[]{
                    LootTableIdCondition.builder(ResourceUtils.parse(description.getChestId())).build(),
                    LootItemRandomChanceCondition.randomChance(description.getChance()).build()
            }, description.getItem()));
        });
    }
}
