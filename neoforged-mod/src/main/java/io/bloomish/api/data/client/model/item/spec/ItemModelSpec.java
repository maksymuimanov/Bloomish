package io.bloomish.api.data.client.model.item.spec;

import net.minecraft.core.Holder;
import net.minecraft.world.item.Item;

public record ItemModelSpec<T extends Item>(
        Holder<T> itemHolder
) {
    public T getItem() {
        return itemHolder.value();
    }
}
