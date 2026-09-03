package io.bloomish.api.data.client.blockstate.property;

import java.util.Locale;

public interface EnumBlockStateProperty extends BlockStateProperty {
    @Override
    default String getKey() {
        return this.getClass()
                .getSimpleName()
                .replaceAll("([a-z])([A-Z])", "$1_$2")
                .toLowerCase(Locale.ROOT);
    }

    default String getValue() {
        return this.name()
                .toLowerCase(Locale.ROOT);
    }

    String name();
}