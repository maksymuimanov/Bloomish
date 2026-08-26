package io.bloomish.api.data.server.map;

import net.minecraft.core.Holder;
import net.minecraft.world.level.block.Block;

public record WaxableDto(Holder<? extends Block> block, String waxedBlock, boolean replace) {
}