package io.bloomish.api.data.client.model.item.spec;

import net.minecraft.core.Holder;
import net.minecraft.world.item.Item;

public record ItemModelSpec(
        Holder<? extends Item> itemHolder
) {
    public Item getItem() {
        return itemHolder.value();
    }
}
