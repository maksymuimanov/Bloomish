package io.bloomish.api.trade.wanderer;

import io.bloomish.api.trade.Trade;
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
