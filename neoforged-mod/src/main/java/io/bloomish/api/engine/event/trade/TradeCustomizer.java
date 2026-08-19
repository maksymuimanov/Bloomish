package io.bloomish.api.engine.event.trade;

import io.bloomish.api.engine.event.trade.object.VillagerTrade;
import io.bloomish.api.engine.event.trade.object.WandererTrade;
import net.neoforged.neoforge.event.village.VillagerTradesEvent;
import net.neoforged.neoforge.event.village.WandererTradesEvent;

public interface TradeCustomizer {
    void customize(VillagerTradesEvent event, VillagerTrade villagerTrade);

    void customize(WandererTradesEvent event, WandererTrade wandererTrade);
}
