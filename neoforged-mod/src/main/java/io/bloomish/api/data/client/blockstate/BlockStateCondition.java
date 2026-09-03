package io.bloomish.api.data.client.blockstate;

import io.bloomish.api.data.client.blockstate.property.BlockStateProperty;
import org.jetbrains.annotations.NotNull;

public record BlockStateCondition(
        String key,
        String value
) {
    public static BlockStateCondition fromProperty(BlockStateProperty property) {
        return new BlockStateCondition(property.getKey(), property.getValue());
    }

    @Override
    @NotNull
    public String toString() {
        return this.key + "=" + this.value;
    }
}
