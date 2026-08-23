package io.bloomish.api.fov;

import io.bloomish.api.engine.metadata.annotation.injection.Injected;
import io.bloomish.api.util.CollectionUtils;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.client.event.ComputeFovModifierEvent;

import java.util.List;

@Injected
public class BowFOVModifier implements FOVModifier {
    private static final float TICKS_PER_SECOND = 20.0F;
    private static final float MAX_DRAW_PROGRESS = 1.0F;
    private static final float FOV_REDUCTION = 0.15F;

    @Override
    public void modify(ComputeFovModifierEvent event, Item item, Item... items) {
        List<Item> combinedItems = CollectionUtils.listOf(item, items);
        if (this.checkItems(event, combinedItems)) {
            float fov = event.getPlayer().getTicksUsingItem() / TICKS_PER_SECOND;
            fov = fov > MAX_DRAW_PROGRESS
                    ? MAX_DRAW_PROGRESS
                    : fov * fov;
            event.setNewFovModifier(event.getFovModifier() * (MAX_DRAW_PROGRESS - fov * FOV_REDUCTION));
        }
    }

    private boolean checkItems(ComputeFovModifierEvent event, List<Item> items) {
        return items.stream()
                .anyMatch(item -> this.checkUsingItem(event, item));
    }

    private boolean checkUsingItem(ComputeFovModifierEvent event, Item item) {
        Player player = event.getPlayer();
        return player.getUseItem().is(item) && player.isUsingItem();
    }
}