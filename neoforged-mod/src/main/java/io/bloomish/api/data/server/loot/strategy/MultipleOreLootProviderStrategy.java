package io.bloomish.api.data.server.loot.strategy;

import io.bloomish.api.data.server.loot.ApiBlockLootTableProvider;
import io.bloomish.api.data.server.loot.LootProviderStrategy;
import io.bloomish.api.data.server.loot.spec.MultipleOreBlockLootTableSpec;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

public class MultipleOreLootProviderStrategy implements LootProviderStrategy<MultipleOreBlockLootTableSpec> {
    @Override
    public void generateLoot(MultipleOreBlockLootTableSpec spec, ApiBlockLootTableProvider provider) {
        Block block = spec.getBlock();
        Item item = spec.getOtherItem();
        float minCount = spec.getMinCount();
        float maxCount = spec.getMaxCount();
        HolderLookup.RegistryLookup<Enchantment> registrylookup = provider.getRegistries().lookupOrThrow(Registries.ENCHANTMENT);
        provider.add(block, provider.createSilkTouchDispatchTable(block, provider.applyExplosionDecay(block, LootItem.lootTableItem(item)
                .apply(SetItemCountFunction.setCount(UniformGenerator.between(minCount, maxCount)))
                .apply(ApplyBonusCount.addOreBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE))))));

    }
}
