package io.bloomish.api.fml;

import io.bloomish.api.engine.metadata.annotation.injection.Injected;
import net.minecraft.world.item.Item;

@Injected
public class InstrumentClientSetup extends AbstractItemClientSetup {
    private static final String TOOTING = "tooting";
    private static final float FULL_TOOT = 1.0F;
    private static final float NO_TOOT = 0.0F;

    @Override
    protected void setupItem(Item item) {
        this.registerTooting(item);
    }

    private void registerTooting(Item item) {
        this.registerProperty(item, TOOTING, (stack, level, entity, seed) ->
                this.isEntityUsing(stack, entity) ? FULL_TOOT : NO_TOOT
        );
    }
}
