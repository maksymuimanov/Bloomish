package io.bloomish.api.engine.event.data.map;

import net.minecraft.core.Holder;
import net.minecraft.world.level.block.Block;

public record WaxableDto(Holder<? extends Block> block, String waxedBlock, boolean replace) {
}