package io.bloomish.api.data.client.model.item.spec;

import net.minecraft.core.Holder;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public record BlockItemModelSpec<T extends Block>(
        Holder<T> blockHolder
) {
    public Item getItem() {
        return this.getBlock().asItem();
    }

    public T getBlock() {
        return blockHolder.value();
    }
}
