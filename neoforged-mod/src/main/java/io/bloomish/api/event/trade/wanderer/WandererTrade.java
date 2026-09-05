package io.bloomish.api.event.trade.wanderer;

import io.bloomish.api.event.trade.Trade;
import net.minecraft.world.item.trading.MerchantOffer;

public record WandererTrade(
        MerchantOffer offer,
        TradeRarity tradeRarity
) implements Trade {
    public enum TradeRarity {
        GENERIC,
        RARE
    }
}
