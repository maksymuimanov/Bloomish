package io.bloomish.api.fml;

import io.bloomish.api.engine.metadata.annotation.injection.Injected;
import net.minecraft.world.item.Item;

@Injected
public class ShieldClientSetup extends AbstractItemClientSetup {
    private static final String BLOCKING = "blocking";
    private static final float FULL_BLOCK = 1.0F;
    private static final float NO_BLOCK = 0.0F;

    @Override
    public void setup(Item data) {
        this.registerBlocking(data);
    }

    private void registerBlocking(Item item) {
        this.registerProperty(item, BLOCKING, (stack, level, entity, seed) ->
                this.isEntityUsing(stack, entity) ? FULL_BLOCK : NO_BLOCK
        );
    }
}
