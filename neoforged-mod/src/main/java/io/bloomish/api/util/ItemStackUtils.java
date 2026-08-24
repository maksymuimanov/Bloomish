package io.bloomish.api.util;

import net.minecraft.world.item.ItemStack;

public final class ItemStackUtils {
    private ItemStackUtils() {
    }

    public static boolean isEmpty(ItemStack itemStack) {
        return itemStack == null || itemStack.isEmpty();
    }
}
