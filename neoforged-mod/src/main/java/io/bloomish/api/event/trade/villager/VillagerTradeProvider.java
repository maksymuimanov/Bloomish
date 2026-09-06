package io.bloomish.api.event.trade.villager;

import io.bloomish.api.bean.Injected;
import io.bloomish.api.event.trade.TradeProvider;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.neoforged.neoforge.event.village.VillagerTradesEvent;

import java.util.List;

@Injected
public class VillagerTradeProvider implements TradeProvider<VillagerTradesEvent, VillagerTrade> {
    @Override
    public void provide(VillagerTradesEvent event, VillagerTrade trade) {
        if (event.getType() == trade.profession()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            trades.get(trade.level()).add((trader, random) -> trade.offer());
        }
    }
}
