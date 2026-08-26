package io.bloomish.api.data.server.modifier;

import net.minecraft.world.item.Item;

public interface ChestModifierDescription {
    String getModifierName();

    Item getItem();

    String getChestId();

    float getChance();
}
