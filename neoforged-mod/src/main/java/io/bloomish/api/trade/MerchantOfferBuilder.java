package io.bloomish.api.trade;

import io.bloomish.api.util.ItemStackUtils;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.trading.ItemCost;
import net.minecraft.world.item.trading.MerchantOffer;

import java.util.Optional;

public final class MerchantOfferBuilder {
    private ItemCost baseCostA;
    private ItemCost costB;
    private ItemStack result;
    private int uses = 0;
    private int maxUses = 12;
    private int xp = 1;
    private float priceMultiplier = 0.05F;
    private int demand = 0;
    private int specialPriceDiff = 0;

    public static MerchantOfferBuilder of(ItemCost baseCostA, ItemStack result) {
        return create()
                .baseCostA(baseCostA)
                .result(result);
    }

    public static MerchantOfferBuilder create() {
        return new MerchantOfferBuilder();
    }

    private MerchantOfferBuilder() {
    }

    public MerchantOfferBuilder baseCostA(ItemCost baseCostA) {
        this.baseCostA = baseCostA;
        return this;
    }

    public MerchantOfferBuilder costB(ItemCost costB) {
        this.costB = costB;
        return this;
    }

    public MerchantOfferBuilder result(ItemStack result) {
        this.result = result;
        return this;
    }

    public MerchantOfferBuilder uses(int uses) {
        this.uses = uses;
        return this;
    }

    public MerchantOfferBuilder maxUses(int maxUses) {
        this.maxUses = maxUses;
        return this;
    }

    public MerchantOfferBuilder xp(int xp) {
        this.xp = xp;
        return this;
    }

    public MerchantOfferBuilder experience(int xp) {
        return this.xp(xp);
    }

    public MerchantOfferBuilder priceMultiplier(float priceMultiplier) {
        this.priceMultiplier = priceMultiplier;
        return this;
    }

    public MerchantOfferBuilder demand(int demand) {
        this.demand = demand;
        return this;
    }

    public MerchantOfferBuilder specialPriceDiff(int specialPriceDiff) {
        this.specialPriceDiff = specialPriceDiff;
        return this;
    }

    public MerchantOffer build() {
        if (this.baseCostA == null) {
            throw new IllegalStateException("MerchantOffer requires a primary cost (baseCostA).");
        }
        if (ItemStackUtils.isEmpty(this.result)) {
            throw new IllegalStateException("MerchantOffer requires a non-empty result item stack.");
        }

        MerchantOffer offer = new MerchantOffer(
                this.baseCostA,
                Optional.ofNullable(this.costB),
                this.result,
                this.uses,
                this.maxUses,
                this.xp,
                this.priceMultiplier,
                this.demand
        );

        if (this.specialPriceDiff != 0) {
            offer.setSpecialPriceDiff(this.specialPriceDiff);
        }

        return offer;
    }
}
