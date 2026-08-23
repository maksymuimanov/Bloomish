package io.bloomish.api.fml;

import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.CrossbowItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.component.ChargedProjectiles;

public class CrossbowClientSetup extends AbstractItemClientSetup {
    private static final String PULL = "pull";
    private static final String PULLING = "pulling";
    private static final String CHARGED = "charged";
    private static final String FIREWORK = "firework";
    private static final float FULL_PULL = 1.0F;
    private static final float NO_PULL = 0.0F;

    @Override
    public void setup(Item data) {
        this.registerPull(data);
        this.registerPulling(data);
        this.registerCharged(data);
        this.registerChargedFirework(data);
    }

    private void registerPull(Item item) {
        this.registerProperty(item, PULL, (stack, level, entity, seed) -> {
            if (entity == null || CrossbowItem.isCharged(stack)) return NO_PULL;
            return (float)(stack.getUseDuration(entity) - entity.getUseItemRemainingTicks()) / (float) CrossbowItem.getChargeDuration(stack, entity);
        });
    }

    private void registerPulling(Item item) {
        this.registerProperty(item, PULLING, (stack, level, entity, seed) ->
                this.isEntityUsing(stack, entity) && !CrossbowItem.isCharged(stack) ? FULL_PULL : NO_PULL
        );
    }

    private void registerCharged(Item item) {
        this.registerProperty(item, CHARGED, (stack, level, entity, seed) ->
                entity != null && CrossbowItem.isCharged(stack) ? FULL_PULL : NO_PULL
        );
    }

    private void registerChargedFirework(Item item) {
        this.registerProperty(item, FIREWORK, (stack, level, entity, seed) -> {
            ChargedProjectiles chargedprojectiles = stack.get(DataComponents.CHARGED_PROJECTILES);
            return entity != null && chargedprojectiles != null && chargedprojectiles.contains(Items.FIREWORK_ROCKET)
                    ? FULL_PULL
                    : NO_PULL;
        });
    }
}
