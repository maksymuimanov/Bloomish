package io.bloomish.api.engine.event.client;

import net.minecraft.world.item.Item;

public class InstrumentClientSetup extends AbstractItemClientSetup {
    private static final String TOOTING = "tooting";
    private static final float FULL_TOOT = 1.0F;
    private static final float NO_TOOT = 0.0F;

    @Override
    protected void setupItem(Item item) {
        this.registerProperty(item, TOOTING, (stack, level, entity, seed) ->
                this.isEntityUsing(stack, entity) ? FULL_TOOT : NO_TOOT
        );
    }
}
