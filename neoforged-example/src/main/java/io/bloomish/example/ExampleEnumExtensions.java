package io.bloomish.example;

import io.bloomish.api.core.util.EnumExtensionUtils;

public class ExampleEnumExtensions {
    public static Object EXAMPLE_BOAT(int id, Class<?> type) {
        return EnumExtensionUtils.createBoatType(id, type, "example:example_planks", "example:example", "example:example_boat", "example:example_chest_boat");
    }
}
