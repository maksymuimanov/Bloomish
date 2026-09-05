package io.bloomish.api.event.trade.villager;

import io.bloomish.api.event.trade.Trade;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.item.trading.MerchantOffer;

public record VillagerTrade(
        VillagerProfession profession,
        int level,
        MerchantOffer offer
) implements Trade {
}