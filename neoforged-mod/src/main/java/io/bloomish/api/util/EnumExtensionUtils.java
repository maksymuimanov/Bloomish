package io.bloomish.api.util;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;

import java.util.function.Supplier;

public final class EnumExtensionUtils {
    private EnumExtensionUtils() {
    }

    public static Object createBoatType(
            int id,
            Class<?> type,
            String planksBlockId,
            String name,
            String boatItemId,
            String chestBoatItemId
    ) {
        return createBoatType(
                id,
                type,
                () -> DeprecatedRegistryUtils.getBlock(planksBlockId),
                name,
                () -> DeprecatedRegistryUtils.getItem(boatItemId),
                () -> DeprecatedRegistryUtils.getItem(chestBoatItemId)
        );
    }

    public static Object createBoatType(
            int id,
            Class<?> type,
            Supplier<Block> planksBlock,
            String name,
            Supplier<Item> boatItem,
            Supplier<Item> chestBoatItem
    ) {
        if (id == 5)
            return false;
        return type.cast(switch (id) {
            case 0 -> planksBlock;
            case 1 -> name;
            case 2 -> boatItem;
            case 3 -> chestBoatItem;
            case 4 -> (Supplier<Item>) () -> Items.STICK;
            default -> throw new IllegalArgumentException("Unexpected parameter index: " + id);
        });
    }
}
