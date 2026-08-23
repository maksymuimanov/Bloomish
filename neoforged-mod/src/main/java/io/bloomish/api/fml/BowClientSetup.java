package io.bloomish.api.fml;

import net.minecraft.world.item.Item;

public class BowClientSetup extends AbstractItemClientSetup {
    private static final String PULL = "pull";
    private static final String PULLING = "pulling";
    private static final float FULL_PULL = 1.0F;
    private static final float NO_PULL = 0.0F;
    private static final float TICKS_PER_SECOND = 20.0F;

    @Override
    public void setup(Item data) {
        this.registerPull(data);
        this.registerPulling(data);
    }

    private void registerPull(Item item) {
        this.registerProperty(item, PULL, (stack, level, entity, seed) -> {
            if (entity == null || entity.getUseItem() != stack) return NO_PULL;
            return (float) (stack.getUseDuration(entity) - entity.getUseItemRemainingTicks()) / TICKS_PER_SECOND;
        });
    }

    private void registerPulling(Item item) {
        this.registerProperty(item, PULLING, (stack, level, entity, seed) ->
                this.isEntityUsing(stack, entity) ? FULL_PULL : NO_PULL
        );
    }
}
