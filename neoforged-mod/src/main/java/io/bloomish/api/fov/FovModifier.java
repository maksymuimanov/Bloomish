package io.bloomish.api.fov;

import net.minecraft.world.item.Item;
import net.neoforged.neoforge.client.event.ComputeFovModifierEvent;

public interface FovModifier {
    void modify(ComputeFovModifierEvent event, Item item, Item... items);
}
