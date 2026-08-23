package io.bloomish.api.fml;

import net.minecraft.world.item.Item;

public class InstrumentClientSetup extends AbstractItemClientSetup {
    private static final String TOOTING = "tooting";
    private static final float FULL_TOOT = 1.0F;
    private static final float NO_TOOT = 0.0F;

    @Override
    public void setup(Item data) {
        this.registerTooting(data);
    }

    private void registerTooting(Item item) {
        this.registerProperty(item, TOOTING, (stack, level, entity, seed) ->
                this.isEntityUsing(stack, entity) ? FULL_TOOT : NO_TOOT
        );
    }
}
