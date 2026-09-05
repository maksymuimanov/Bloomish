package io.bloomish.api.data.client.model.block.holder;

import net.minecraft.core.Holder;
import net.minecraft.world.level.block.Block;

import java.util.Optional;

public record BlockHolder(
        Holder<? extends Block> block,
        Optional<String> texture
) {
    public Block value() {
        return block.value();
    }
}
