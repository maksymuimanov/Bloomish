package io.bloomish.api.trade.wanderer;

import io.bloomish.api.engine.metadata.annotation.injection.Injected;
import io.bloomish.api.trade.TradeProvider;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.neoforged.neoforge.event.village.WandererTradesEvent;

import java.util.List;

@Injected
public class WandererTradeProvider implements TradeProvider<WandererTradesEvent, WandererTrade> {
    @Override
    public void provide(WandererTradesEvent event, WandererTrade trade) {
        List<VillagerTrades.ItemListing> trades = getTradesByRarity(event, trade);
        trades.add((trader, random) -> trade.offer());
    }

    private List<VillagerTrades.ItemListing> getTradesByRarity(WandererTradesEvent event, WandererTrade trade) {
        return trade.tradeRarity() == WandererTrade.TradeRarity.GENERIC
                ? event.getGenericTrades()
                : event.getRareTrades();
    }
}
