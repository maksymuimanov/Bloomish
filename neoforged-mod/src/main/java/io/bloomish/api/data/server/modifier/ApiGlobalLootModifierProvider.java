package io.bloomish.api.data.server.modifier;

import io.bloomish.api.channel.DataChannels;
import io.bloomish.api.channel.ValueChannelBus;
import io.bloomish.api.common.loot.AddItemModifier;
import io.bloomish.api.engine.context.ModContext;
import io.bloomish.api.util.DeprecatedResourceUtils;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.neoforged.neoforge.common.data.GlobalLootModifierProvider;
import net.neoforged.neoforge.common.loot.LootTableIdCondition;

import java.util.concurrent.CompletableFuture;

public class ApiGlobalLootModifierProvider extends GlobalLootModifierProvider {
    private final ValueChannelBus channelBus;

    public ApiGlobalLootModifierProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, ModContext.getModId());
        this.channelBus = ModContext.getObject(ValueChannelBus.class);
    }

    @Override
    protected void start() {
        this.channelBus.<ChestModifierDescription>forEachDrain(DataChannels.API_GLOBAL_LOOT_MODIFIER_PROVIDER,
                description -> {
                    add(description.getModifierName(), new AddItemModifier(new LootItemCondition[]{
                            LootTableIdCondition.builder(DeprecatedResourceUtils.parse(description.getChestId())).build(),
                            LootItemRandomChanceCondition.randomChance(description.getChance()).build()
                    }, description.getItem()));
                });
    }
}
