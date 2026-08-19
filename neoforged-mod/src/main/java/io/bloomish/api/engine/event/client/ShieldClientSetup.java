package io.bloomish.api.engine.event.client;

import net.minecraft.world.item.Item;

public class ShieldClientSetup extends AbstractItemClientSetup {
    private static final String BLOCKING = "blocking";
    private static final float FULL_BLOCK = 1.0F;
    private static final float NO_BLOCK = 0.0F;

    @Override
    protected void setupItem(Item item) {
        this.registerProperty(item, BLOCKING, (stack, level, entity, seed) ->
                this.isEntityUsing(stack, entity) ? FULL_BLOCK : NO_BLOCK
        );
    }
}
